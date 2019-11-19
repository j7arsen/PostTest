package com.j7arsen.postproject.ui.block.base;

import com.j7arsen.domain.model.person.PostPersonModel;
import com.j7arsen.postproject.utils.error.ErrorData;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface IBasePostBlockView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showProgress();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideProgress();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showError(ErrorData errorData);

    @StateStrategyType(SingleStateStrategy.class)
    void showPostPersonData(PostPersonModel postPersonModel);

}
