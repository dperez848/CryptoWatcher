package com.napsis.cryptowatcher.app.ui.main;

import com.kogimobile.android.baselibrary.app.base.BaseActivityInnerNavigation;
import com.kogimobile.android.baselibrary.app.base.BaseFragment;
import com.kogimobile.android.baselibrary.app.base.navigation.BaseActivityInnerNavigationController;
import com.napsis.cryptowatcher.R;

import java.util.HashMap;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class NavigationControllerActivityMain extends BaseActivityInnerNavigationController{

    private HashMap<String, BaseFragment> navFragments;


    public NavigationControllerActivityMain(BaseActivityInnerNavigation activity) {
        super(activity, R.id.container);
        initFragments();

    }

    private void initFragments() {
        this.navFragments = new HashMap<>();
        this.navFragments.put(getSection1Title(), FrgMain.newInstance());
    }


    private String getSection1Title() {
        return getContext().getString(R.string.app_name);
    }

    public void navigateToSection1() {
        navigateToRootLevel(this.navFragments.get(getSection1Title()), getSection1Title());
    }




}
