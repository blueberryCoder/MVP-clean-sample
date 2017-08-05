package com.blueberry.start.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blueberry.star.domain.model.Star;
import com.blueberry.start.R;
import com.blueberry.start.presentation.internal.di.components.StarComponent;
import com.blueberry.start.presentation.presenter.UserListPresenter;
import com.blueberry.start.presentation.view.StarListView;
import com.blueberry.start.presentation.view.adapter.StarListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by blueberry on 8/4/2017.
 */

public class StarListFragment extends BaseFragment implements StarListView {

    @Inject
    UserListPresenter mPresenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Unbinder unbinder;

    public static StarListFragment newInstance() {

        Bundle args = new Bundle();

        StarListFragment fragment = new StarListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(StarComponent.class).inject(this);
        mPresenter.setView(this);
        mPresenter.initialize();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_star_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }



    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void renderStarList(List<Star> models) {
        recyclerView.setAdapter(new StarListAdapter(getActivity(), models));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
