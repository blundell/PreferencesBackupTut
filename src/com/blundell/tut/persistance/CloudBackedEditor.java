package com.blundell.tut.persistance;

import java.util.Set;

import android.app.backup.BackupManager;
import android.content.SharedPreferences.Editor;

/**
 * This is our cloud editor, whenever one of the sharedpreferences is changed we inform the backup manager (saving to the cloud)
 * Doing this here allows us to keep the Activity clean and the Activity doesnt even need to know we are saving to the cloud!
 * @author paul.blundell
 *
 */
public class CloudBackedEditor implements Editor {

	private final Editor editor;
	private final BackupManager backupManager;

	public CloudBackedEditor(Editor editor, BackupManager backupManager) {
		this.editor = editor;
		this.backupManager = backupManager;
	}

	@Override
	public void apply() {
		throw new UnsupportedOperationException("Just a tutorial");
	}

	@Override
	public Editor clear() {
		editor.clear();
		return this;
	}

	@Override
	public boolean commit() {
		boolean commit = editor.commit();
		backupManager.dataChanged();
		return commit;
	}

	@Override
	public Editor putBoolean(String key, boolean value) {
		editor.putBoolean(key, value);
		return this;
	}

	@Override
	public Editor putFloat(String key, float value) {
		editor.putFloat(key, value);
		return this;
	}

	@Override
	public Editor putInt(String key, int value) {
		editor.putInt(key, value);
		return this;
	}

	@Override
	public Editor putLong(String key, long value) {
		editor.putLong(key, value);
		return this;
	}

	@Override
	public Editor putString(String key, String value) {
		editor.putString(key, value);
		return this;
	}

	@Override
	public Editor putStringSet(String arg0, Set<String> arg1) {
		throw new UnsupportedOperationException("Just a tutorial");
	}

	@Override
	public Editor remove(String key) {
		editor.remove(key);
		return this;
	}
}