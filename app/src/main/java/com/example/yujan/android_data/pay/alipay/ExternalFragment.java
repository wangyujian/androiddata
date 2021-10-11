package com.example.yujan.android_data.pay.alipay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.yujan.android_data.R;
import androidx.fragment.app.Fragment;


public class ExternalFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		return inflater.inflate(R.layout.pay_external, container, false);
	}
}
