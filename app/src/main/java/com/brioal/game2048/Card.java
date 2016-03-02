package com.brioal.game2048;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {

	public Card(Context context) {
		super(context);
				
		label = new TextView(getContext());
		label.setTextSize(32);
		label.setGravity(Gravity.CENTER);
		
		LayoutParams lp = new LayoutParams(-1, -1);
		lp.setMargins(10, 10, 0, 0);
		addView(label, lp);
		
		setNum(0);
	}
	
	
	private int num = 0;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
		TextPaint textPaint = label.getPaint();
		label.setTextSize(40);
		if (num<=0) {
			label.setText("");
		}else{
			label.setText(num + "");
		}

		switch (num) {
            case 0:
                label.setBackgroundColor(getResources().getColor(R.color.back_in));
				label.setTextColor(Color.BLACK);

				break;
			case 2:
				label.setBackgroundColor(getResources().getColor(R.color.color_2));
				label.setTextColor(Color.BLACK);

				break;

			case 4:
				label.setBackgroundColor(getResources().getColor(R.color.color_4));
				label.setTextColor(Color.BLACK);

				break;
			case 8:
				label.setBackgroundColor(getResources().getColor(R.color.color_8));
				label.setTextColor(Color.WHITE);

				break;
			case 16:
				label.setBackgroundColor(getResources().getColor(R.color.color_16));
				label.setTextColor(Color.WHITE);
				break;
			case 32:
				label.setBackgroundColor(getResources().getColor(R.color.color_32));
				label.setTextColor(Color.WHITE);
				break;
			case 64:
				label.setBackgroundColor(getResources().getColor(R.color.color_64));
				label.setTextColor(Color.WHITE);
				break;

			case 128:
				label.setBackgroundColor(getResources().getColor(R.color.color_128));
				label.setTextColor(Color.WHITE);
				break;

			case 256:
				label.setBackgroundColor(getResources().getColor(R.color.color_256));
				label.setTextColor(Color.WHITE);
				break;

			case 512:
				label.setBackgroundColor(getResources().getColor(R.color.color_512));
				label.setTextColor(Color.WHITE);
				break;

			case 1024:
				label.setBackgroundColor(getResources().getColor(R.color.color_1024));
				label.setTextColor(Color.WHITE);
				break;
			case 2048:
				label.setBackgroundColor(getResources().getColor(R.color.color_2048));
				label.setTextColor(Color.WHITE);
				break;

			default:
				label.setBackgroundColor(getResources().getColor(R.color.color_2048));
				label.setTextColor(Color.WHITE);
				break;

		}
		textPaint.setFakeBoldText(true);
		invalidate();
	}
	
	public boolean equals(Card o) {
		return getNum()==o.getNum();
	}

	private TextView label;
}
