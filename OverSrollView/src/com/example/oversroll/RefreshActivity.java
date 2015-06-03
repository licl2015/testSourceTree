package com.example.oversroll;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.oversroll.widget.OverScrollView;
import com.example.oversroll.widget.OverScrollView.OverScrollListener;
import com.example.oversroll.widget.OverScrollView.OverScrollTinyListener;

public class RefreshActivity extends Activity implements OverScrollListener, OverScrollTinyListener{

	/**
	 * ��ʼ�����ֵ������ͼƬ�����صı�Եֵ
	 */
	private static final int PADDING = -100;
	
	private ImageView mHeaderImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_refresh);
		
		mHeaderImage = (ImageView) findViewById(R.id.image);
		
		OverScrollView scrollView = (OverScrollView) findViewById(R.id.layout);
		
		scrollView.setOverScrollListener(this);
		scrollView.setOverScrollTinyListener(this);
		
		// ����ͼƬ�ĳ�ʼ�߽�
		// ��֤�����ܳ��ַŴ�ͼƬ��Ч��
		scrollLoosen();
	}

	@Override
	public void scrollDistance(int tinyDistance, int totalDistance) {
		if (totalDistance > 0 || tinyDistance == 0
				|| mHeaderImage.getPaddingBottom() == 0) {
			return;
		}
		int padding = PADDING - totalDistance / 2;
		if (padding > 0) {
			padding = 0;
		}
		mHeaderImage.setPadding(padding, 0, padding, padding);
	}

	@Override
	public void scrollLoosen() {
		int padding = PADDING;
		mHeaderImage.setPadding(padding, 0, padding, padding);
		
		// ���������ɿ�ʱ�ص�
	}

	@Override
	public void headerScroll() {
		Toast.makeText(getApplicationContext(), "��ʼˢ��", Toast.LENGTH_SHORT).show();
		
		// ������������һ���ٽ�ֵʱ �Ļص�
	}

	@Override
	public void footerScroll() {
		// ������������һ���ٽ�ֵʱ �Ļص�
	}

}
