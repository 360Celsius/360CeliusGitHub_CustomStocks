package com.celsius.customstocks.dbhelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.celsius.customstocks.application.CustomStockApplication;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Provider extends ContentProvider {

    @Inject DBHelper helper;

    private static final int ALL_SYMBOLS = 1;
    private static final int MARKETS = 2;
    private static final int QUOTES = 3;
    private static final int VALEUBYVENUE = 4;
    private static final int EARNING = 5;
    private static final int FINANCIALS = 6;


    private static final UriMatcher mMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        mMatcher.addURI(DBContract.AUTHORITY, DBContract.AllSymbols.URI_SUFFIX, ALL_SYMBOLS);
        mMatcher.addURI(DBContract.AUTHORITY, DBContract.Markets.URI_SUFFIX, MARKETS);
        mMatcher.addURI(DBContract.AUTHORITY, DBContract.Quotes.URI_SUFFIX, QUOTES);
        mMatcher.addURI(DBContract.AUTHORITY, DBContract.ValueByVenue.URI_SUFFIX, VALEUBYVENUE);
        mMatcher.addURI(DBContract.AUTHORITY, DBContract.Earnings.URI_SUFFIX, EARNING);
        mMatcher.addURI(DBContract.AUTHORITY, DBContract.Financials.URI_SUFFIX, FINANCIALS);

    }


    @Override
    public boolean onCreate() {
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

        CustomStockApplication.getMyComponent().inject(this);

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
            case MARKETS:
                tableName = DBContract.Markets.TABLE_NAME;
                break;
            case QUOTES:
                tableName = DBContract.Quotes.TABLE_NAME;
                break;
            case VALEUBYVENUE:
                tableName = DBContract.ValueByVenue.TABLE_NAME;
                break;
            case EARNING:
                tableName = DBContract.Earnings.TABLE_NAME;
                break;
            case FINANCIALS:
                tableName = DBContract.Financials.TABLE_NAME;
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
            case MARKETS:
                contentUriName = DBContract.Markets.CONTENT_URI;
                break;
            case QUOTES:
                contentUriName = DBContract.Quotes.CONTENT_URI;
                break;
            case VALEUBYVENUE:
                contentUriName = DBContract.ValueByVenue.CONTENT_URI;
                break;
            case EARNING:
                contentUriName = DBContract.Earnings.CONTENT_URI;
                break;
            case FINANCIALS:
                contentUriName = DBContract.Financials.CONTENT_URI;
                break;

        }

        return contentUriName;
    }
}
