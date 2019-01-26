package com.celsius.customstocks.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.celsius.customstocks.datamodels.Symbol;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper sInstance;
    // Database Info
    private static final String DATABASE_NAME = "CustomStocksDatabase";
    private static final int DATABASE_VERSION = 2;
    private Context context;

    public static synchronized DBHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     */
    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContract.SQL_CREATE_All_SYMBOLS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.SQL_DELETE_All_SYMBOLS_TABLE);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }


    //============ ALL Symbols ==============

    public void bulkInsertAllSymbolsToSymbolsDataTable(ArrayList<Symbol> allSymbolsParsed) {
        deleteAllSymbolsTAble();
        try {
            ContentValues[] contentsArr = new ContentValues[allSymbolsParsed.size()];

            for (int i = 0; i < allSymbolsParsed.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(DBContract.AllSymbols.COLUMN_NAME_SYMBOL, allSymbolsParsed.get(i).getSymbol());
                values.put(DBContract.AllSymbols.COLUMN_NAME_NAME, allSymbolsParsed.get(i).getName());
                values.put(DBContract.AllSymbols.COLUMN_NAME_DATE, allSymbolsParsed.get(i).getDate());
                values.put(DBContract.AllSymbols.COLUMN_NAME_IS_ENABLED, allSymbolsParsed.get(i).getIsEnabled());
                values.put(DBContract.AllSymbols.COLUMN_NAME_TYPE, allSymbolsParsed.get(i).getType());
                values.put(DBContract.AllSymbols.COLUMN_NAME_IEX_ID, allSymbolsParsed.get(i).getIexId());
                values.put(DBContract.AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO, "0");
                contentsArr[i] = values;

            }
            context.getContentResolver().bulkInsert(DBContract.AllSymbols.CONTENT_URI, contentsArr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSymbolsTableEmpty() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor mCursor = db.rawQuery(DBContract.SQL_SELECT_All_SYMBOLS_TABLE, null);
        Boolean rowExists = false;
        try {

            if (mCursor.moveToFirst()) {
                // DO SOMETHING WITH CURSOR
                rowExists = true;

            } else {
                // I AM EMPTY
                rowExists = false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return rowExists;
        }finally {
            if (mCursor != null && !mCursor.isClosed()) {
                mCursor.close();
            }
            return  rowExists;

        }
    }

    public int getAllSymbolsTableRowCount() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor mCursor = db.rawQuery(DBContract.SQL_SELECT_All_SYMBOLS_TABLE, null);
        int count = 0;
        try {

            count = mCursor.getCount();

        }catch (Exception e){
            e.printStackTrace();
            return count;
        }finally {
            if (mCursor != null && !mCursor.isClosed()) {
                mCursor.close();
            }
            return  count;

        }

    }

    private void deleteAllSymbolsTAble(){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DBContract.AllSymbols.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }


    public ArrayList<Symbol> getAllSymbols() {

        ArrayList<Symbol> allSymbolsList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DBContract.SQL_SELECT_All_SYMBOLS_TABLE, null);

        try {
            if (cursor.moveToFirst()) {
                do {

                    Symbol symbol = new Symbol();
                    symbol.setDate(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_DATE)));
                    symbol.setIexId(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IEX_ID)));
                    symbol.setIsEnabled(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IS_ENABLED)));
                    symbol.setName(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_NAME)));
                    symbol.setSymbol(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_SYMBOL)));
                    symbol.setType(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_TYPE)));
                    symbol.setIsInPortfolio(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO)));

                    allSymbolsList.add(symbol);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return allSymbolsList;
        }
    }

    public Symbol getLatesetInsertedSymbo(){
        Symbol symbol = new Symbol();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DBContract.SQL_SELECT_LAST_INSERTED_ROW, null);

        try {
            if (cursor.moveToFirst()) {
                symbol.setDate(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_DATE)));
                symbol.setIexId(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IEX_ID)));
                symbol.setIsEnabled(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IS_ENABLED)));
                symbol.setName(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_NAME)));
                symbol.setSymbol(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_SYMBOL)));
                symbol.setType(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_TYPE)));
                symbol.setIsInPortfolio(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO)));

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return symbol;
        }
    }
}
