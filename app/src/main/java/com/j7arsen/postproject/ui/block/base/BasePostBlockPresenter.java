package com.j7arsen.postproject.ui.block.base;

import moxy.MvpPresenter;
import moxy.MvpView;

public abstract class BasePostBlockPresenter<View extends MvpView> extends MvpPresenter<View> {

    protected abstract void loadBlock(long personsCount);

    protected abstract void reloadBlock();

}
