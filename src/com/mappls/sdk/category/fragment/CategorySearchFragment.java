package com.mappls.sdk.category.fragment;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.mappls.sdk.category.R;
import com.mappls.sdk.category.databinding.MapplsCategorySearchItemFragmentBinding;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class CategorySearchFragment extends Fragment {
    public static final a Companion = new a(0);
    private MapplsCategorySearchItemFragmentBinding binding;
    private ImageView cancelView;
    private com.mappls.sdk.category.adapters.a categorySearchAdapter;
    private ICategorySelectionListener listener;
    private com.mappls.sdk.category.viewmodel.b mViewModel;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }

        @JvmStatic
        public static CategorySearchFragment a() {
            SearchCategoryUIOption searchCategoryUIOptionBuild = SearchCategoryUIOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(searchCategoryUIOptionBuild, "builder().build()");
            return a(searchCategoryUIOptionBuild);
        }

        @JvmStatic
        public static CategorySearchFragment a(SearchCategoryUIOption options) {
            Intrinsics.checkNotNullParameter(options, "options");
            CategorySearchFragment categorySearchFragment = new CategorySearchFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.mappls.sdk.category.CATEGORY_UI_OPTION", options);
            categorySearchFragment.setArguments(bundle);
            return categorySearchFragment;
        }
    }

    public static final class b implements com.mappls.sdk.category.adapters.a.InterfaceC0067a {
        b() {
        }

        @Override // com.mappls.sdk.category.adapters.a.InterfaceC0067a
        public final void a(List<? extends CategoryCode> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            if (list.isEmpty()) {
                Toast.makeText(CategorySearchFragment.this.getContext(), "Please select at least one category", 0).show();
                return;
            }
            ICategorySelectionListener iCategorySelectionListener = CategorySearchFragment.this.listener;
            if (iCategorySelectionListener != null) {
                iCategorySelectionListener.onCategorySelected(list);
            }
        }
    }

    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding = CategorySearchFragment.this.binding;
            com.mappls.sdk.category.adapters.a aVar = null;
            if (mapplsCategorySearchItemFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                mapplsCategorySearchItemFragmentBinding = null;
            }
            String string = ((EditText) mapplsCategorySearchItemFragmentBinding.mapplsCategoryAppbar.findViewById(R.id.mappls_category_search_input)).getText().toString();
            com.mappls.sdk.category.adapters.a aVar2 = CategorySearchFragment.this.categorySearchAdapter;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categorySearchAdapter");
            } else {
                aVar = aVar2;
            }
            aVar.getFilter().filter(string);
        }
    }

    private final void initCategory() {
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding = this.binding;
        com.mappls.sdk.category.adapters.a aVar = null;
        if (mapplsCategorySearchItemFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding = null;
        }
        RecyclerView recyclerView = mapplsCategorySearchItemFragmentBinding.mapplsCategoryCategoryRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mapplsCategoryCategoryRecyclerView");
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        if (getContext() != null) {
            com.mappls.sdk.category.viewmodel.b bVar = this.mViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                bVar = null;
            }
            Integer numMaxSelectionCount = bVar.b().maxSelectionCount();
            Intrinsics.checkNotNullExpressionValue(numMaxSelectionCount, "mViewModel.options.maxSelectionCount()");
            int iIntValue = numMaxSelectionCount.intValue();
            com.mappls.sdk.category.viewmodel.b bVar2 = this.mViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                bVar2 = null;
            }
            this.categorySearchAdapter = new com.mappls.sdk.category.adapters.a(iIntValue, bVar2.c(), new b());
        }
        com.mappls.sdk.category.adapters.a aVar2 = this.categorySearchAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categorySearchAdapter");
            aVar2 = null;
        }
        recyclerView.setAdapter(aVar2);
        com.mappls.sdk.category.viewmodel.b bVar3 = this.mViewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar3 = null;
        }
        List<CategoryCode> listA = bVar3.a();
        if (listA != null) {
            com.mappls.sdk.category.adapters.a aVar3 = this.categorySearchAdapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categorySearchAdapter");
            } else {
                aVar = aVar3;
            }
            aVar.a(new ArrayList(listA));
        }
    }

    @JvmStatic
    public static final CategorySearchFragment newInstance() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final CategorySearchFragment newInstance(SearchCategoryUIOption searchCategoryUIOption) {
        Companion.getClass();
        return a.a(searchCategoryUIOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(CategorySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding = this$0.binding;
        if (mapplsCategorySearchItemFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding = null;
        }
        ((EditText) mapplsCategorySearchItemFragmentBinding.mapplsCategoryAppbar.findViewById(R.id.mappls_category_search_input)).setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(CategorySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ICategorySelectionListener iCategorySelectionListener = this$0.listener;
        if (iCategorySelectionListener != null) {
            iCategorySelectionListener.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(CategorySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.mappls.sdk.category.adapters.a aVar = this$0.categorySearchAdapter;
        com.mappls.sdk.category.viewmodel.b bVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categorySearchAdapter");
            aVar = null;
        }
        ArrayList arrayListA = aVar.a();
        int size = arrayListA.size();
        com.mappls.sdk.category.viewmodel.b bVar2 = this$0.mViewModel;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar2 = null;
        }
        Integer numMaxSelectionCount = bVar2.b().maxSelectionCount();
        Intrinsics.checkNotNullExpressionValue(numMaxSelectionCount, "mViewModel.options.maxSelectionCount()");
        if (size <= numMaxSelectionCount.intValue()) {
            if (arrayListA.isEmpty()) {
                Toast.makeText(this$0.getContext(), "Please select at least one category", 0).show();
                return;
            }
            ICategorySelectionListener iCategorySelectionListener = this$0.listener;
            if (iCategorySelectionListener != null) {
                iCategorySelectionListener.onCategorySelected(arrayListA);
                return;
            }
            return;
        }
        Context context = this$0.getContext();
        StringBuilder sb = new StringBuilder("Max ");
        com.mappls.sdk.category.viewmodel.b bVar3 = this$0.mViewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            bVar = bVar3;
        }
        sb.append(bVar.b().maxSelectionCount().intValue());
        sb.append(" categories are allowed");
        Toast.makeText(context, sb.toString(), 0).show();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBindingInflate = MapplsCategorySearchItemFragmentBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(mapplsCategorySearchItemFragmentBindingInflate, "inflate(inflater, container, false)");
        this.binding = mapplsCategorySearchItemFragmentBindingInflate;
        if (mapplsCategorySearchItemFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBindingInflate = null;
        }
        View root = mapplsCategorySearchItemFragmentBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        com.mappls.sdk.category.utils.b.a(fragmentActivityRequireActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        com.mappls.sdk.category.viewmodel.b bVar = this.mViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar = null;
        }
        outState.putParcelable("com.mappls.sdk.category.CATEGORY_UI_OPTION", bVar.c());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        int i;
        Bundle arguments;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        com.mappls.sdk.category.viewmodel.b bVar = (com.mappls.sdk.category.viewmodel.b) new ViewModelProvider(this).get(com.mappls.sdk.category.viewmodel.b.class);
        this.mViewModel = bVar;
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar = null;
        }
        bVar.a(com.mappls.sdk.category.a.b());
        if (bundle == null && (arguments = getArguments()) != null) {
            com.mappls.sdk.category.viewmodel.b bVar2 = this.mViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                bVar2 = null;
            }
            SearchCategoryUIOption searchCategoryUIOptionD = (SearchCategoryUIOption) arguments.getParcelable("com.mappls.sdk.category.CATEGORY_UI_OPTION");
            if (searchCategoryUIOptionD == null) {
                searchCategoryUIOptionD = com.mappls.sdk.category.a.d();
            }
            bVar2.a(searchCategoryUIOptionD);
            arguments.clear();
        }
        initCategory();
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding2 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding2 = null;
        }
        CoordinatorLayout coordinatorLayout = mapplsCategorySearchItemFragmentBinding2.mapplsCategoryLayoutBackground;
        com.mappls.sdk.category.viewmodel.b bVar3 = this.mViewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar3 = null;
        }
        Integer numBackgroundColor = bVar3.c().backgroundColor();
        Intrinsics.checkNotNullExpressionValue(numBackgroundColor, "mViewModel.searchUiOption.backgroundColor()");
        coordinatorLayout.setBackgroundColor(numBackgroundColor.intValue());
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding3 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding3 = null;
        }
        AppBarLayout appBarLayout = mapplsCategorySearchItemFragmentBinding3.mapplsCategoryAppbar;
        com.mappls.sdk.category.viewmodel.b bVar4 = this.mViewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar4 = null;
        }
        Integer numBackgroundColor2 = bVar4.c().backgroundColor();
        Intrinsics.checkNotNullExpressionValue(numBackgroundColor2, "mViewModel.searchUiOption.backgroundColor()");
        appBarLayout.setBackgroundColor(numBackgroundColor2.intValue());
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding4 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding4 = null;
        }
        TextView textView2 = mapplsCategorySearchItemFragmentBinding4.mapplsCategoryButtonNext;
        com.mappls.sdk.category.viewmodel.b bVar5 = this.mViewModel;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar5 = null;
        }
        Integer numNextButtonTextColor = bVar5.c().nextButtonTextColor();
        Intrinsics.checkNotNullExpressionValue(numNextButtonTextColor, "mViewModel.searchUiOption.nextButtonTextColor()");
        textView2.setTextColor(numNextButtonTextColor.intValue());
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.mappls_category_button_background);
        if (drawable != null) {
            com.mappls.sdk.category.viewmodel.b bVar6 = this.mViewModel;
            if (bVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                bVar6 = null;
            }
            Integer numNextButtonColor = bVar6.c().nextButtonColor();
            Intrinsics.checkNotNullExpressionValue(numNextButtonColor, "mViewModel.searchUiOption.nextButtonColor()");
            drawable.setColorFilter(new PorterDuffColorFilter(numNextButtonColor.intValue(), PorterDuff.Mode.SRC_IN));
        }
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding5 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding5 = null;
        }
        mapplsCategorySearchItemFragmentBinding5.mapplsCategoryButtonNext.setBackground(drawable);
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding6 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding6 = null;
        }
        ImageView imageView = mapplsCategorySearchItemFragmentBinding6.mapplsCategoryBackIcon;
        com.mappls.sdk.category.viewmodel.b bVar7 = this.mViewModel;
        if (bVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar7 = null;
        }
        Integer numBackIcon = bVar7.c().backIcon();
        Intrinsics.checkNotNullExpressionValue(numBackIcon, "mViewModel.searchUiOption.backIcon()");
        imageView.setImageResource(numBackIcon.intValue());
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding7 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding7 = null;
        }
        EditText editText = mapplsCategorySearchItemFragmentBinding7.mapplsCategorySearchInput;
        com.mappls.sdk.category.viewmodel.b bVar8 = this.mViewModel;
        if (bVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar8 = null;
        }
        Integer numSearchTextColor = bVar8.c().searchTextColor();
        Intrinsics.checkNotNullExpressionValue(numSearchTextColor, "mViewModel.searchUiOption.searchTextColor()");
        editText.setTextColor(numSearchTextColor.intValue());
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding8 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding8 = null;
        }
        EditText editText2 = mapplsCategorySearchItemFragmentBinding8.mapplsCategorySearchInput;
        com.mappls.sdk.category.viewmodel.b bVar9 = this.mViewModel;
        if (bVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar9 = null;
        }
        Integer numHintTextColor = bVar9.c().hintTextColor();
        Intrinsics.checkNotNullExpressionValue(numHintTextColor, "mViewModel.searchUiOption.hintTextColor()");
        editText2.setHintTextColor(numHintTextColor.intValue());
        com.mappls.sdk.category.viewmodel.b bVar10 = this.mViewModel;
        if (bVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar10 = null;
        }
        Integer numMaxSelectionCount = bVar10.b().maxSelectionCount();
        if (numMaxSelectionCount != null && numMaxSelectionCount.intValue() == 1) {
            MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding9 = this.binding;
            if (mapplsCategorySearchItemFragmentBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                mapplsCategorySearchItemFragmentBinding9 = null;
            }
            textView = mapplsCategorySearchItemFragmentBinding9.mapplsCategoryButtonNext;
            i = 8;
        } else {
            MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding10 = this.binding;
            if (mapplsCategorySearchItemFragmentBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                mapplsCategorySearchItemFragmentBinding10 = null;
            }
            textView = mapplsCategorySearchItemFragmentBinding10.mapplsCategoryButtonNext;
            i = 0;
        }
        textView.setVisibility(i);
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding11 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding11 = null;
        }
        View viewFindViewById = mapplsCategorySearchItemFragmentBinding11.mapplsCategorySearchClearBtn.findViewById(R.id.mappls_category_search_clear_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "binding.mapplsCategorySe…ategory_search_clear_btn)");
        ImageView imageView2 = (ImageView) viewFindViewById;
        this.cancelView = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelView");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.category.fragment.CategorySearchFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CategorySearchFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding12 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding12 = null;
        }
        ((EditText) mapplsCategorySearchItemFragmentBinding12.mapplsCategoryAppbar.findViewById(R.id.mappls_category_search_input)).addTextChangedListener(new c());
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding13 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsCategorySearchItemFragmentBinding13 = null;
        }
        ((ImageView) mapplsCategorySearchItemFragmentBinding13.mapplsCategoryAppbar.findViewById(R.id.mappls_category_back_icon)).setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.category.fragment.CategorySearchFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CategorySearchFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        MapplsCategorySearchItemFragmentBinding mapplsCategorySearchItemFragmentBinding14 = this.binding;
        if (mapplsCategorySearchItemFragmentBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            mapplsCategorySearchItemFragmentBinding = mapplsCategorySearchItemFragmentBinding14;
        }
        mapplsCategorySearchItemFragmentBinding.mapplsCategoryButtonNext.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.category.fragment.CategorySearchFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CategorySearchFragment.onViewCreated$lambda$3(this.f$0, view2);
            }
        });
    }

    public final void setCategoryCodes(List<? extends CategoryCode> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        com.mappls.sdk.category.viewmodel.b bVar = this.mViewModel;
        if (bVar != null) {
            com.mappls.sdk.category.viewmodel.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                bVar = null;
            }
            bVar.a(categories);
            com.mappls.sdk.category.adapters.a aVar = this.categorySearchAdapter;
            if (aVar != null) {
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("categorySearchAdapter");
                    aVar = null;
                }
                com.mappls.sdk.category.viewmodel.b bVar3 = this.mViewModel;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    bVar2 = bVar3;
                }
                List<CategoryCode> listA = bVar2.a();
                if (listA == null) {
                    listA = CollectionsKt.emptyList();
                }
                aVar.a(listA);
            }
        }
    }

    public final void setCategorySelectionListener(ICategorySelectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
