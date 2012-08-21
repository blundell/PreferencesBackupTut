package com.blundell.tut.ui.phone;

import com.blundell.tut.R;
import com.blundell.tut.persistance.CloudBackedSharedPreferences;
import com.blundell.tut.persistance.PreferenceConstants;
import com.blundell.tut.persistance.TutorialPreferences;

import android.app.Activity;
import android.app.backup.BackupManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText inputEditText;
	private TextView displayTextView;
	private TutorialPreferences pref;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = (EditText) findViewById(R.id.main_edit_text_input);
        displayTextView = (TextView) findViewById(R.id.main_text_view_display);

        // Setup your shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(PreferenceConstants.TUTORIAL_PREFERENCES, MODE_PRIVATE);
        // Backup manager is what tells the android system about your preferences
        BackupManager backupManager = new BackupManager(this);
        // We wrap our shared preferences in another sharedpreferences that will also inform the backup manager
        CloudBackedSharedPreferences preferences = new CloudBackedSharedPreferences(sharedPreferences, backupManager);
        // We then wrap again so we can have convenience methods that describe what you are saving (keeping your activity cleaner)
        pref = new TutorialPreferences(preferences);
        // Set the name from shared preferences - on the very first install this will be blank, then from then on it will be whatever the user entered
        displayTextView.setText(pref.getName());
    }

    public void onSaveInput(View button) {
    	String input = inputEditText.getText().toString();
    	// Check the user has entered some text
    	if(!"".equals(input)){
    		// Update the UI
    		displayTextView.setText(input);
    		// Save to shared preferences
    		pref.saveName(input);
    	}
    }
}