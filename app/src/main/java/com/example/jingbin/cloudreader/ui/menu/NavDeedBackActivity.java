package com.example.jingbin.cloudreader.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.jingbin.cloudreader.R;
import com.example.jingbin.cloudreader.base.BaseActivity;
import com.example.jingbin.cloudreader.databinding.ActivityNavDeedBackBinding;
import com.example.jingbin.cloudreader.utils.PerfectClickListener;
import com.example.jingbin.cloudreader.view.webview.WebViewActivity;

public class NavDeedBackActivity extends BaseActivity<ActivityNavDeedBackBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_deed_back);
        setTitle("问题反馈");
        showContentView();

        bindingView.tvIssues.setOnClickListener(listener);
        bindingView.tvJianshu.setOnClickListener(listener);
        bindingView.tvQq.setOnClickListener(listener);
        bindingView.tvEmail.setOnClickListener(listener);
    }

    private PerfectClickListener listener = new PerfectClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.tv_issues:
                    String issuesUrl = "https://github.com/youlookwhat/CloudReader/issues";
//                    String issuesUrl = "http://jingbin.me/2017/11/23/%E5%BC%80%E5%8F%91%E4%B8%AD%E6%89%80%E9%81%87%E9%97%AE%E9%A2%98%E5%BD%92%E7%BA%B3/";
                    WebViewActivity.loadUrl(NavDeedBackActivity.this, issuesUrl, "加载中...");
                    break;
                case R.id.tv_qq:
                    String url = "mqqwpa://im/chat?chat_type=wpa&uin=770413277";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    break;
                case R.id.tv_email:
                    Intent data = new Intent(Intent.ACTION_SENDTO);
                    data.setData(Uri.parse("mailto:jingbin127@163.com"));
                    startActivity(data);
                    break;
                case R.id.tv_jianshu:
                    String jianshuUrl = "http://www.jianshu.com/users/e43c6e979831/latest_articles";
                    WebViewActivity.loadUrl(NavDeedBackActivity.this, jianshuUrl, "加载中...");

//                    Uri uri = Uri.parse("http://www.jianshu.com/users/e43c6e979831/latest_articles");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
                    break;
            }
        }
    };

    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, NavDeedBackActivity.class);
        mContext.startActivity(intent);
    }
}