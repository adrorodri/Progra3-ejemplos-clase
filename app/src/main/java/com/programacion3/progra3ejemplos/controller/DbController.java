package com.programacion3.progra3ejemplos.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.programacion3.progra3ejemplos.model.LoginAttempt;

import java.util.LinkedList;
import java.util.List;

public class DbController extends SQLiteOpenHelper {
    public DbController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE loginAttempts (_id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, password TEXT, successful BOOLEAN);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS loginAttempts;");
        onCreate(sqLiteDatabase);
    }

    public void addLoginAttempt(String username, String password, boolean b) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("usuario", username);
            contentValues.put("password", password);
            contentValues.put("successful", b);
            getWritableDatabase().insertOrThrow("loginAttempts", null, contentValues);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select de toda la base de datos
    public List<LoginAttempt> selectAllLoginAttempts() {
        try {
            List<LoginAttempt> loginAttempts = new LinkedList<>();
            Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM loginAttempts", null);
            while (cursor.moveToNext()) {
                loginAttempts.add(
                        new LoginAttempt(
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getInt(3) == 1
                        )
                );
            }
            cursor.close();
            return loginAttempts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Select de la base de datos con un filtro
    public List<LoginAttempt> selectAllFailedLoginAttempts() {
        try {
            List<LoginAttempt> loginAttempts = new LinkedList<>();
            Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM loginAttempts WHERE successful = 0", null);
            while (cursor.moveToNext()) {
                loginAttempts.add(
                        new LoginAttempt(
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getInt(3) == 1
                        )
                );
            }
            cursor.close();
            return loginAttempts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateLoginAttemptName(String newName) {
        try {
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("usuario", newName);
//            getWritableDatabase().update("loginAttempts", contentValues, "successful = 1", null);

            getWritableDatabase().execSQL("UPDATE loginAttempts SET usuario = ? WHERE successful = 1", new String[]{newName});
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete from the database
    public void deleteLoginAttempts(String nombre) {
        try {
            getWritableDatabase().delete("loginAttempts", "usuario = ?", new String[]{nombre});
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
