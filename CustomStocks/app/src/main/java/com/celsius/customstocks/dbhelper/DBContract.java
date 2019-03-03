package com.celsius.customstocks.dbhelper;

import android.net.Uri;
import android.provider.BaseColumns;

import com.celsius.customstocks.datamodels.Earning;

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
        public static final String COLUMN_NAME_ROW_ID = "rowid";


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
                    AllSymbols.COLUMN_NAME_ROW_ID + " TEXT," +
                    AllSymbols.COLUMN_NAME_IEX_ID + " TEXT)";

    public static final String SQL_DELETE_All_SYMBOLS_TABLE =
            "DROP TABLE IF EXISTS " + AllSymbols.TABLE_NAME;

    public static final String SQL_SELECT_All_SYMBOLS_TABLE =
            "SELECT  * FROM " + AllSymbols.TABLE_NAME + " WHERE "+ AllSymbols._ID;

    public static final String SQL_SELECT_All_SELECTED_SYMBOLS_TABLE =
            "SELECT  * FROM " + AllSymbols.TABLE_NAME + " WHERE "+ AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO + " = 1";



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
        public static final String COLUMN_NAME_ROW_ID = "rowid";


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
                    Markets.COLUMN_NAME_ROW_ID + " TEXT," +
                    Markets.COLUMN_NAME_LAST_UPDATED + " TEXT)";

    public static final String SQL_DELETE_MARKETS_TABLE =
            "DROP TABLE IF EXISTS " + Markets.TABLE_NAME;

    public static final String SQL_SELECT_MARKETS_TABLE =
            "SELECT  * FROM " + Markets.TABLE_NAME + " WHERE "+ Markets._ID;

    //============ ============ ==============

    //=================  Quotes =================
    public static class Quotes implements BaseColumns {
        public static final String URI_SUFFIX = "quotes";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "quotes";

        public static final String COLUMN_NAME_SYMBOL = "symbol";
        public static final String COLUMN_NAME_COMPAJY_NAME = "companyName";
        public static final String COLUMN_NAME_PROMARY_EXCAHNGE = "primaryExchange";
        public static final String COLUMN_NAME_SECTOR = "sector";
        public static final String COLUMN_NAME_CALCULATION_PRICE = "calculationPrice";
        public static final String COLUMN_NAME_OPEN = "open";
        public static final String COLUMN_NAME_OPEN_TIME = "openTime";
        public static final String COLUMN_NAME_CLOSE = "close";
        public static final String COLUMN_NAME_CLOSE_TIME = "closeTime";
        public static final String COLUMN_NAME_HIGH = "high";
        public static final String COLUMN_NAME_LOW = "low";
        public static final String COLUMN_NAME_LATEST_PRICE = "latestPrice";
        public static final String COLUMN_NAME_LATEST_SOURCE = "latestSource";
        public static final String COLUMN_NAME_LATEST_TIME = "latestTime";
        public static final String COLUMN_NAME_LATEST_UPDATE = "latestUpdate";
        public static final String COLUMN_NAME_LATEST_VOLUME = "latestVolume";
        public static final String COLUMN_NAME_IEX_REALTIME_PRICE = "iexRealtimePrice";
        public static final String COLUMN_NAME_IEX_REALTIME_SIZE = "iexRealtimeSize";
        public static final String COLUMN_NAME_IEX_LAST_UPDATE = "iexLastUpdated";
        public static final String COLUMN_NAME_DELAYED_PRICE = "delayedPrice";
        public static final String COLUMN_NAME_DELAYED_PRICE_TIME = "delayedPriceTime";
        public static final String COLUMN_NAME_EXTENDED_PRICE = "extendedPrice";
        public static final String COLUMN_NAME_EXTENDED_SHNAGE = "extendedChange";
        public static final String COLUMN_NAME_EXTENDED_CHANGE_PERCENT = "extendedChangePercent";
        public static final String COLUMN_NAME_EXTENDED_PRICE_TIME = "extendedPriceTime";
        public static final String COLUMN_NAME_PREVIOUS_CLOSE = "previousClose";
        public static final String COLUMN_NAME_CHNAGE = "change";
        public static final String COLUMN_NAME_CHANGE_PERCENT = "changePercent";
        public static final String COLUMN_NAME_IEX_MARKET_PERCENT = "iexMarketPercent";
        public static final String COLUMN_NAME_IEX_VOLUME = "iexVolume";
        public static final String COLUMN_NAME_AVG_TOTAL_VOLUME = "avgTotalVolume";
        public static final String COLUMN_NAME_IEX_BID_PRICE = "iexBidPrice";
        public static final String COLUMN_NAME_IEX_BID_SIZE = "iexBidSize";
        public static final String COLUMN_NAME_IEX_ASK_PRICE = "iexAskPrice";
        public static final String COLUMN_NAME_IEX_ASK_SIZE= "iexAskSize";
        public static final String COLUMN_NAME_MARKET_CUP = "marketCap";
        public static final String COLUMN_NAME_PE_RATIO = "peRatio";
        public static final String COLUMN_NAME_WEEK_52_HIGH = "week52High";
        public static final String COLUMN_NAME_WEEK_52_LOW = "week52Low";
        public static final String COLUMN_NAME_YTD_CHANGE = "ytdChange";
        public static final String COLUMN_NAME_ROW_ID = "rowid";

    }

    public static final String SQL_CREATE_QUOTES_TABLE =
            "CREATE TABLE " + Quotes.TABLE_NAME + " (" +
                    Quotes._ID + " INTEGER PRIMARY KEY," +
                    Quotes.COLUMN_NAME_SYMBOL + " TEXT," +
                    Quotes.COLUMN_NAME_COMPAJY_NAME + " TEXT," +
                    Quotes.COLUMN_NAME_PROMARY_EXCAHNGE + " TEXT," +
                    Quotes.COLUMN_NAME_SECTOR + " TEXT," +
                    Quotes.COLUMN_NAME_CALCULATION_PRICE + " TEXT," +
                    Quotes.COLUMN_NAME_OPEN + " TEXT," +
                    Quotes.COLUMN_NAME_OPEN_TIME + " TEXT," +
                    Quotes.COLUMN_NAME_CLOSE + " TEXT," +
                    Quotes.COLUMN_NAME_CLOSE_TIME + " TEXT," +
                    Quotes.COLUMN_NAME_HIGH + " TEXT," +
                    Quotes.COLUMN_NAME_LOW + " TEXT," +
                    Quotes.COLUMN_NAME_LATEST_PRICE + " TEXT," +
                    Quotes.COLUMN_NAME_LATEST_SOURCE + " TEXT," +
                    Quotes.COLUMN_NAME_LATEST_TIME + " TEXT," +
                    Quotes.COLUMN_NAME_LATEST_UPDATE + " TEXT," +
                    Quotes.COLUMN_NAME_LATEST_VOLUME + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_REALTIME_PRICE + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_REALTIME_SIZE + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_LAST_UPDATE + " TEXT," +
                    Quotes.COLUMN_NAME_DELAYED_PRICE + " TEXT," +
                    Quotes.COLUMN_NAME_DELAYED_PRICE_TIME + " TEXT," +
                    Quotes.COLUMN_NAME_EXTENDED_PRICE + " TEXT," +
                    Quotes.COLUMN_NAME_EXTENDED_SHNAGE + " TEXT," +
                    Quotes.COLUMN_NAME_EXTENDED_CHANGE_PERCENT + " TEXT," +
                    Quotes.COLUMN_NAME_EXTENDED_PRICE_TIME + " TEXT," +
                    Quotes.COLUMN_NAME_PREVIOUS_CLOSE + " TEXT," +
                    Quotes.COLUMN_NAME_CHNAGE + " TEXT," +
                    Quotes.COLUMN_NAME_CHANGE_PERCENT + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_MARKET_PERCENT + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_VOLUME + " TEXT," +
                    Quotes.COLUMN_NAME_AVG_TOTAL_VOLUME + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_BID_PRICE + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_BID_SIZE + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_ASK_PRICE + " TEXT," +
                    Quotes.COLUMN_NAME_IEX_ASK_SIZE + " TEXT," +
                    Quotes.COLUMN_NAME_MARKET_CUP + " TEXT," +
                    Quotes.COLUMN_NAME_PE_RATIO + " TEXT," +
                    Quotes.COLUMN_NAME_WEEK_52_HIGH + " TEXT," +
                    Quotes.COLUMN_NAME_WEEK_52_LOW + " TEXT," +
                    Quotes.COLUMN_NAME_YTD_CHANGE + " TEXT," +
                    Quotes.COLUMN_NAME_ROW_ID + " TEXT)";

    public static final String SQL_DELETE_QUOTES_TABLE =
            "DROP TABLE IF EXISTS " + Quotes.TABLE_NAME;

    public static final String SQL_SELECT_QUOTES_TABLE =
            "SELECT  * FROM " + Quotes.TABLE_NAME + " WHERE "+ Quotes._ID;

    //============ ============ ==============

    //=================  NEWS =================
    public static class News implements BaseColumns {
        public static final String URI_SUFFIX = "news";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US, CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "news";

        public static final String COLUMN_NAME_DATE_TIME = "datetime";
        public static final String COLUMN_NAME_HEAD_LINE = "headline";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_URL = "url";
        public static final String COLUMN_NAME_SUMARY = "summary";
        public static final String COLUMN_NAME_RELATED = "related";
        public static final String COLUMN_NAME_IMAGE = "image";
        public static final String COLUMN_NAME_ROW_ID = "rowid";


    }

    public static final String SQL_CREATE_NEWS_TABLE =
            "CREATE TABLE " + News.TABLE_NAME + " (" +
                    News._ID + " INTEGER PRIMARY KEY," +
                    News.COLUMN_NAME_DATE_TIME + " TEXT," +
                    News.COLUMN_NAME_HEAD_LINE + " TEXT," +
                    News.COLUMN_NAME_SOURCE + " TEXT," +
                    News.COLUMN_NAME_URL + " TEXT," +
                    News.COLUMN_NAME_SUMARY + " TEXT," +
                    News.COLUMN_NAME_RELATED + " TEXT," +
                    News.COLUMN_NAME_ROW_ID + " TEXT," +
                    News.COLUMN_NAME_IMAGE + " TEXT)";

    public static final String SQL_DELETE_NEWS_TABLE =
            "DROP TABLE IF EXISTS " + News.TABLE_NAME;

    public static final String SQL_SELECT_NEWS_TABLE =
            "SELECT  * FROM " + News.TABLE_NAME + " WHERE "+ News._ID;


    //============ ============ ==============

    //=================  EARNINGS =================
    public static class Earnings implements BaseColumns {
        public static final String URI_SUFFIX = "earnings";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US, CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "earnings";

        public static final String COLUMN_NAME_SYMBOL = "symbol";
        public static final String COLUMN_NAME_ACTUAL_ESP = "actualEPS";
        public static final String COLUMN_NAME_CONSENSUS_ESP = "consensusEPS";
        public static final String COLUMN_NAME_ESTIMATED_ESP = "estimatedEPS";
        public static final String COLUMN_NAME_ANNOUNCE_TIME = "announceTime";
        public static final String COLUMN_NAME_NUMBER_OF_ESTIMATES = "numberOfEstimates";
        public static final String COLUMN_NAME_EPS_SURPRISE_DOLLAR = "ePSSurpriseDollar";
        public static final String COLUMN_NAME_EPS_REPORT_DATE = "ePSReportDate";
        public static final String COLUMN_NAME_FISCA_PERIOD = "fiscalPeriod";
        public static final String COLUMN_NAME_FISCAL_END_DATE = "fiscalEndDate";
        public static final String COLUMN_NAME_YEAR_AGO = "yearAgo";
        public static final String COLUMN_NAME_YEAR_AGO_CHANGE_PERCENT = "yearAgoChangePercent";
        public static final String COLUMN_NAME_ESTIMATED_CHANGE_PERCENT = "estimatedChangePercent";
        public static final String COLUMN_NAME_SYMBOL_ID = "symbolId";
        public static final String COLUMN_NAME_ROW_ID = "rowid";
    }

    public static final String SQL_CREATE_EARNING_TABLE =
            "CREATE TABLE " + Earnings.TABLE_NAME + " (" +
                    Earnings._ID + " INTEGER PRIMARY KEY," +
                    Earnings.COLUMN_NAME_SYMBOL + " TEXT," +
                    Earnings.COLUMN_NAME_ACTUAL_ESP + " TEXT," +
                    Earnings.COLUMN_NAME_CONSENSUS_ESP + " TEXT," +
                    Earnings.COLUMN_NAME_ESTIMATED_ESP + " TEXT," +
                    Earnings.COLUMN_NAME_ANNOUNCE_TIME + " TEXT," +
                    Earnings.COLUMN_NAME_NUMBER_OF_ESTIMATES + " TEXT," +
                    Earnings.COLUMN_NAME_EPS_SURPRISE_DOLLAR + " TEXT," +
                    Earnings.COLUMN_NAME_EPS_REPORT_DATE + " TEXT," +
                    Earnings.COLUMN_NAME_FISCA_PERIOD + " TEXT," +
                    Earnings.COLUMN_NAME_FISCAL_END_DATE + " TEXT," +
                    Earnings.COLUMN_NAME_YEAR_AGO + " TEXT," +
                    Earnings.COLUMN_NAME_YEAR_AGO_CHANGE_PERCENT + " TEXT," +
                    Earnings.COLUMN_NAME_ESTIMATED_CHANGE_PERCENT + " TEXT," +
                    Earnings.COLUMN_NAME_SYMBOL_ID + " TEXT," +
                    Earnings.COLUMN_NAME_ROW_ID + " TEXT)";

    public static final String SQL_DELETE_EARNINGS_TABLE =
            "DROP TABLE IF EXISTS " + Earnings.TABLE_NAME;

    public static final String SQL_SELECT_EARNINGS_TABLE =
            "SELECT  * FROM " + Earnings.TABLE_NAME + " WHERE "+ Earnings._ID +" ORDER BY strftime('%Y-%m-%d', "+Earnings.COLUMN_NAME_EPS_REPORT_DATE+") DESC";
}
