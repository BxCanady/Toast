package com.sygor.hellotoast;

/**
 * Created by mightysam on 10/14/17.
 */

class MainPresenterImpl implements com.sygor.hellotoast.MainPresenter {

    private int initialCount;
    private com.sygor.hellotoast.MainView view;

    public MainPresenterImpl(com.sygor.hellotoast.MainView view) {
        initialCount = 0;
        this.view = view;
    }

    @Override
    public void showToastClicked() {
        view.showToast(initialCount);
    }

    @Override
    public void countUpClicked() {
        initialCount++;
        view.updateCount(initialCount);
    }

    @Override
    public void init() {
        view.updateCount(initialCount);
    }

    @Override
    public void init(int initCount) {
        this.initialCount = initCount;
        init();
    }

    @Override
    public int getCount() {
        return initialCount;
    }
}
