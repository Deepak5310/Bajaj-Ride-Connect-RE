package com.drew.metadata.wav;

import com.drew.imaging.riff.RiffHandler;
import com.drew.lang.ByteArrayReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import de.patwoz.rn.bluetoothstatemanager.Constants;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class WavRiffHandler implements RiffHandler {
    private String _currentList = "";
    private final WavDirectory _directory;

    public WavRiffHandler(Metadata metadata) {
        WavDirectory wavDirectory = new WavDirectory();
        this._directory = wavDirectory;
        metadata.addDirectory(wavDirectory);
    }

    @Override // com.drew.imaging.riff.RiffHandler
    public boolean shouldAcceptRiffIdentifier(String str) {
        return str.equals(WavDirectory.FORMAT);
    }

    @Override // com.drew.imaging.riff.RiffHandler
    public boolean shouldAcceptChunk(String str) {
        return str.equals(WavDirectory.CHUNK_FORMAT) || (this._currentList.equals(WavDirectory.LIST_INFO) && WavDirectory._tagIntegerMap.containsKey(str)) || str.equals("data");
    }

    @Override // com.drew.imaging.riff.RiffHandler
    public boolean shouldAcceptList(String str) {
        if (str.equals(WavDirectory.LIST_INFO)) {
            this._currentList = WavDirectory.LIST_INFO;
            return true;
        }
        this._currentList = "";
        return false;
    }

    @Override // com.drew.imaging.riff.RiffHandler
    public void processChunk(String str, byte[] bArr) {
        try {
            if (str.equals(WavDirectory.CHUNK_FORMAT)) {
                ByteArrayReader byteArrayReader = new ByteArrayReader(bArr);
                byteArrayReader.setMotorolaByteOrder(false);
                short int16 = byteArrayReader.getInt16(0);
                short int17 = byteArrayReader.getInt16(2);
                int int32 = byteArrayReader.getInt32(4);
                int int33 = byteArrayReader.getInt32(8);
                short int18 = byteArrayReader.getInt16(12);
                if (int16 == 1) {
                    this._directory.setInt(6, byteArrayReader.getInt16(14));
                    this._directory.setString(1, WavDirectory._audioEncodingMap.get(Integer.valueOf(int16)));
                } else if (WavDirectory._audioEncodingMap.containsKey(Integer.valueOf(int16))) {
                    this._directory.setString(1, WavDirectory._audioEncodingMap.get(Integer.valueOf(int16)));
                } else {
                    this._directory.setString(1, Constants.BluetoothState.UNKNOWN);
                }
                this._directory.setInt(2, int17);
                this._directory.setInt(3, int32);
                this._directory.setInt(4, int33);
                this._directory.setInt(5, int18);
                return;
            }
            if (str.equals("data")) {
                try {
                    if (this._directory.containsTag(4)) {
                        double length = ((double) bArr.length) / this._directory.getDouble(4);
                        int i = (int) length;
                        int iPow = i / ((int) Math.pow(60.0d, 2.0d));
                        Integer numValueOf = Integer.valueOf(iPow);
                        int iPow2 = i / ((int) Math.pow(60.0d, 1.0d));
                        numValueOf.getClass();
                        int i2 = iPow2 - (iPow * 60);
                        Integer numValueOf2 = Integer.valueOf(i2);
                        double dPow = length / Math.pow(60.0d, 0.0d);
                        numValueOf2.getClass();
                        this._directory.setString(16, String.format("%1$02d:%2$02d:%3$02d", numValueOf, numValueOf2, Integer.valueOf((int) Math.round(dPow - ((double) (i2 * 60))))));
                        return;
                    }
                    return;
                } catch (MetadataException unused) {
                    this._directory.addError("Error calculating duration: bytes per second not found");
                    return;
                }
            }
            if (WavDirectory._tagIntegerMap.containsKey(str)) {
                this._directory.setString(WavDirectory._tagIntegerMap.get(str).intValue(), new String(bArr).substring(0, bArr.length - 1));
            }
        } catch (IOException e) {
            this._directory.addError(e.getMessage());
        }
    }
}
