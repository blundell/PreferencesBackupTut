package com.blundell.tut.persistance;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;

/**
 * A backup agent is used by the Android system,
 * it asks your app "What preference files do you want to save to the cloud"
 * @author paul.blundell
 *
 */
public class BlundellBackupAgent extends BackupAgentHelper {

	@Override
	public void onCreate() {
		super.onCreate();
		// A Helper for our Preferences, this name is the same name we use when saving SharedPreferences
		SharedPreferencesBackupHelper helper = new SharedPreferencesBackupHelper(this, PreferenceConstants.TUTORIAL_PREFERENCES);
		addHelper(PreferenceConstants.HELPER_KEY, helper);
	}
}