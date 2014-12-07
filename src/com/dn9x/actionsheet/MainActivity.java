package com.dn9x.actionsheet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dn9x.actionsheet.ActionSheet.ActionSheetListener;
import com.dn9x.actionsheet.ActionSheet.Item;

public class MainActivity extends Activity implements ActionSheetListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v) {
		showActionSheet();
	}

	public void showActionSheet() {
		Item cancelItem = new Item(R.color.white, R.color.bgred, 0, 0,
				R.color.actionsheet_cancel_color, R.color.white, "Cancel");
		Item item1 = new Item(R.color.white, R.color.bgred,
				R.drawable.setting_normal, R.drawable.setting_pressed,
				R.color.bgred, R.color.white, "Setting");
		Item item2 = new Item(R.color.white, R.color.bgred,
				R.drawable.chrome_normal, R.drawable.chrome_pressed,
				R.color.bgred, R.color.white, "Chrome");
		Item item3 = new Item(R.color.white, R.color.bgred,
				R.drawable.play_normal, R.drawable.play_pressed, R.color.bgred,
				R.color.white, "Play", 0.5f);

		ActionSheet.createBuilder(this, this.getFragmentManager())
				.setCancelItem(cancelItem)
				.setmOtherItems(item1, item2, item3)
				.setCancelableOnTouchOutside(true).setListener(this).show();
	}

	@Override
	public void onOtherButtonClick(ActionSheet actionSheet, int index) {
		Toast.makeText(getApplicationContext(), "click item index = " + index,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDismiss(ActionSheet actionSheet, boolean isCancle) {
		Toast.makeText(getApplicationContext(),
				"dismissed isCancle = " + isCancle, Toast.LENGTH_SHORT).show();
	}

}