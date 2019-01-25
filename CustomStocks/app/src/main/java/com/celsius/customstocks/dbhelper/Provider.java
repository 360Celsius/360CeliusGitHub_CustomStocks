package com.celsius.customstocks.dbhelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Provider extends ContentProvider {

    public static DBHelper helper = null;

    private static final int ALL_SYMBOLS = 1;

    private static final UriMatcher mMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        mMatcher.addURI(DBContract.AUTHORITY, DBContract.AllSymbols.URI_SUFFIX, ALL_SYMBOLS);
    }


    @Override
    public boolean onCreate() {
        helper  = DBHelper.getInstance(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String nullColumnHack = null;
        long id = db.insert(getTableName(uri), nullColumnHack, values);

        if(id > -1){
            Uri insertedId = ContentUris.withAppendedId(getContentUriName(uri), id);
            getContext().getContentResolver().notifyChange(insertedId, null);
            return insertedId;
        }
        else
            return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    public static String getTableName(Uri uri) {
        String tableName = null;

        switch (mMatcher.match(uri)) {
            case ALL_SYMBOLS:
                tableName = DBContract.AllSymbols.TABLE_NAME;
                break;

        }

        return tableName;
    }

    public Uri getContentUriName(Uri uri) {
        Uri contentUriName = null;

        switch (mMatcher.match(uri)) {
            case ALL_SYMBOLS:
                contentUriName = DBContract.AllSymbols.CONTENT_URI;
                break;

        }

        return contentUriName;
    }
}
