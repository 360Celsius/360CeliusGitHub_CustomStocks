package com.celsius.customstocks.dbhelper;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.Locale;

public class DBContract {

    public static final String packageName = "com.celsius.customstocks";
    public static final String AUTHORITY = packageName + ".provider";
    public static final String CONTENT_BASE = "content://"+AUTHORITY+"/%s";

    private DBContract() {}


    //============ ALL Symbols ==============
    public static class AllSymbols implements BaseColumns {
        public static final String URI_SUFFIX = "all_symbols";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "all_symbols";

        public static final String COLUMN_NAME_SYMBOL = "symbol";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_IS_ENABLED = "isEnabled";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_IEX_ID = "iexId";
        public static final String COLUMN_NAME_IS_IN_PORTFOLIO = "isInPortfolio";

    }

    public static final String SQL_CREATE_All_SYMBOLS_TABLE =
            "CREATE TABLE " + AllSymbols.TABLE_NAME + " (" +
                    AllSymbols._ID + " INTEGER PRIMARY KEY," +
                    AllSymbols.COLUMN_NAME_SYMBOL + " TEXT," +
                    AllSymbols.COLUMN_NAME_NAME + " TEXT," +
                    AllSymbols.COLUMN_NAME_DATE + " TEXT," +
                    AllSymbols.COLUMN_NAME_IS_ENABLED + " TEXT," +
                    AllSymbols.COLUMN_NAME_TYPE + " TEXT," +
                    AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO + " TEXT," +
                    AllSymbols.COLUMN_NAME_IEX_ID + " TEXT)";

    public static final String SQL_DELETE_All_SYMBOLS_TABLE =
            "DROP TABLE IF EXISTS " + AllSymbols.TABLE_NAME;

    public static final String SQL_SELECT_All_SYMBOLS_TABLE =
            "SELECT  * FROM " + AllSymbols.TABLE_NAME + " WHERE "+ AllSymbols._ID;


    public static final String SQL_SELECT_LAST_INSERTED_ROW =
            "SELECT * FROM "+ AllSymbols.TABLE_NAME+" ORDER BY "+AllSymbols._ID+ " DESC LIMIT 1";
    //============ ============ ==============

    //=================  Markets =================
    public static class Markets implements BaseColumns {
        public static final String URI_SUFFIX = "markets";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "markets";

        public static final String COLUMN_NAME_MIC = "mic";
        public static final String COLUMN_NAME_TAPE_ID = "tapeId";
        public static final String COLUMN_NAME_VOLUME_NAME = "venueName";
        public static final String COLUMN_NAME_VOLUME = "volume";
        public static final String COLUMN_NAME_TAPE_A = "tapeA";
        public static final String COLUMN_NAME_TAPE_B = "tapeB";
        public static final String COLUMN_NAME_TAPE_C = "tapeC";
        public static final String COLUMN_NAME_IMARKET_PERCENTY = "marketPercent";
        public static final String COLUMN_NAME_LAST_UPDATED = "lastUpdated";

    }

    public static final String SQL_CREATE_MARKETS_TABLE =
            "CREATE TABLE " + Markets.TABLE_NAME + " (" +
                    Markets._ID + " INTEGER PRIMARY KEY," +
                    Markets.COLUMN_NAME_MIC + " TEXT," +
                    Markets.COLUMN_NAME_TAPE_ID + " TEXT," +
                    Markets.COLUMN_NAME_VOLUME_NAME + " TEXT," +
                    Markets.COLUMN_NAME_VOLUME + " TEXT," +
                    Markets.COLUMN_NAME_TAPE_A + " TEXT," +
                    Markets.COLUMN_NAME_TAPE_B + " TEXT," +
                    Markets.COLUMN_NAME_TAPE_C + " TEXT," +
                    Markets.COLUMN_NAME_IMARKET_PERCENTY + " TEXT," +
                    Markets.COLUMN_NAME_LAST_UPDATED + " TEXT)";

    public static final String SQL_DELETE_MARKETS_TABLE =
            "DROP TABLE IF EXISTS " + Markets.TABLE_NAME;

    public static final String SQL_SELECT_MARKETS_TABLE =
            "SELECT  * FROM " + Markets.TABLE_NAME + " WHERE "+ Markets._ID;

    //============ ============ ==============


}
