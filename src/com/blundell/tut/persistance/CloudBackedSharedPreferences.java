package com.blundell.tut.persistance;

import java.util.Map;
import java.util.Set;

import android.app.backup.BackupManager;
import android.content.SharedPreferences;

/**
 * This class acts as shared preferences
 * When the editor is requested we send back our CloudEditor so that we have control of what is going on!
 * @author paul.blundell
 *
 */
public class CloudBackedSharedPreferences implements SharedPreferences {

	private final SharedPreferences sharedPreferences;
	private final BackupManager backupManager;

	public CloudBackedSharedPreferences(SharedPreferences sharedPreferences, BackupManager backupManager) {
		this.sharedPreferences = sharedPreferences;
		this.backupManager = backupManager;
	}

	@Override
	public boolean contains(String key) {
		return sharedPreferences.contains(key);
	}

	@Override
	public Editor edit() {
		return new CloudBackedEditor(sharedPreferences.edit(), backupManager);
	}

	@Override
	public Map<String, ?> getAll() {
		return sharedPreferences.getAll();
	}

	@Override
	public boolean getBoolean(String key, boolean defValue) {
		return sharedPreferences.getBoolean(key, defValue);
	}

	@Override
	public float getFloat(String key, float defValue) {
		return sharedPreferences.getFloat(key, defValue);
	}

	@Override
	public int getInt(String key, int defValue) {
		return sharedPreferences.getInt(key, defValue);
	}

	@Override
	public long getLong(String key, long defValue) {
		return sharedPreferences.getLong(key, defValue);
	}

	@Override
	public String getString(String key, String defValue) {
		return sharedPreferences.getString(key, defValue);
	}

	@Override
	public Set<String> getStringSet(String arg0, Set<String> arg1) {
		throw new UnsupportedOperationException("Just a tutorial");
	}

	@Override
	public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
		sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
	}

	@Override
	public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
		sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
	}
}