package com.celsius.customstocks.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.celsius.customstocks.datamodels.Earning;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.News;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.datamodels.Symbol;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import static com.celsius.customstocks.dbhelper.DBContract.AllSymbols.TABLE_NAME;

@Singleton
public class DBHelper extends SQLiteOpenHelper {

    // Database Info
    private static final String DATABASE_NAME = "CustomStocksDatabase";
    private static final int DATABASE_VERSION = 3;
    private Context context;

    @Inject
    public DBHelper(@Named("ApplicationContext") Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBContract.SQL_CREATE_All_SYMBOLS_TABLE);
        db.execSQL(DBContract.SQL_CREATE_MARKETS_TABLE);
        db.execSQL(DBContract.SQL_CREATE_QUOTES_TABLE);
        db.execSQL(DBContract.SQL_CREATE_NEWS_TABLE);
        db.execSQL(DBContract.SQL_CREATE_EARNING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.SQL_DELETE_All_SYMBOLS_TABLE);
        db.execSQL(DBContract.SQL_DELETE_MARKETS_TABLE);
        db.execSQL(DBContract.SQL_DELETE_QUOTES_TABLE);
        db.execSQL(DBContract.SQL_DELETE_NEWS_TABLE);
        db.execSQL(DBContract.SQL_DELETE_EARNINGS_TABLE);
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
                values.put(DBContract.AllSymbols.COLUMN_NAME_ROW_ID, String.valueOf(i+1));
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
                    if(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO)).contains("1")){
                        symbol.setIsInPortfolio(true);
                    }else{
                        symbol.setIsInPortfolio(false);
                    }
                    symbol.setId(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_ROW_ID)));

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

                if(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO)).contains("1")){
                    symbol.setIsInPortfolio(true);
                }else{
                    symbol.setIsInPortfolio(false);
                }

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

    public void addSymbolToWatchList(Symbol symbol){

        try {

            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DBContract.AllSymbols.COLUMN_NAME_SYMBOL, symbol.getSymbol());
            values.put(DBContract.AllSymbols.COLUMN_NAME_NAME, symbol.getName());
            values.put(DBContract.AllSymbols.COLUMN_NAME_DATE, symbol.getDate());
            values.put(DBContract.AllSymbols.COLUMN_NAME_IS_ENABLED, symbol.getIsEnabled());
            values.put(DBContract.AllSymbols.COLUMN_NAME_TYPE, symbol.getType());
            values.put(DBContract.AllSymbols.COLUMN_NAME_IEX_ID, symbol.getIexId());
            values.put(DBContract.AllSymbols.COLUMN_NAME_ROW_ID, symbol.getId());
            if(symbol.getIsInPortfolio() == true)
                values.put(DBContract.AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO, "0");
            else
                values.put(DBContract.AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO, "1");

            db.update(TABLE_NAME, values, "_id="+symbol.getId(), null);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

    }


    public ArrayList<Symbol> getAllSelectedSymbols(){
        ArrayList<Symbol> allSymbolsList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DBContract.SQL_SELECT_All_SELECTED_SYMBOLS_TABLE, null);

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
                    if(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_IS_IN_PORTFOLIO)).contains("1")){
                        symbol.setIsInPortfolio(true);
                    }else{
                        symbol.setIsInPortfolio(false);
                    }
                    symbol.setId(cursor.getString(cursor.getColumnIndex(DBContract.AllSymbols.COLUMN_NAME_ROW_ID)));

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

    //=================  Markets =================

    public void bulkInsertMarketsToMarketsDataTable(ArrayList<Market> marketssListParsed) {
        deletMarketsTAble();
        try {
            ContentValues[] contentsArr = new ContentValues[marketssListParsed.size()];

            for (int i = 0; i < marketssListParsed.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(DBContract.Markets.COLUMN_NAME_MIC, marketssListParsed.get(i).getMic());
                values.put(DBContract.Markets.COLUMN_NAME_TAPE_ID, marketssListParsed.get(i).getTapeId());
                values.put(DBContract.Markets.COLUMN_NAME_VOLUME_NAME, marketssListParsed.get(i).getVenueName());
                values.put(DBContract.Markets.COLUMN_NAME_VOLUME, marketssListParsed.get(i).getVolume());
                values.put(DBContract.Markets.COLUMN_NAME_TAPE_A, marketssListParsed.get(i).getTapeA());
                values.put(DBContract.Markets.COLUMN_NAME_TAPE_B, marketssListParsed.get(i).getTapeB());
                values.put(DBContract.Markets.COLUMN_NAME_TAPE_C, marketssListParsed.get(i).getTapeC());
                values.put(DBContract.Markets.COLUMN_NAME_IMARKET_PERCENTY, marketssListParsed.get(i).getMarketPercent());
                values.put(DBContract.Markets.COLUMN_NAME_LAST_UPDATED, marketssListParsed.get(i).getLastUpdated());
                values.put(DBContract.Markets.COLUMN_NAME_ROW_ID, String.valueOf(i+1));

                contentsArr[i] = values;

            }
            context.getContentResolver().bulkInsert(DBContract.Markets.CONTENT_URI, contentsArr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deletMarketsTAble() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DBContract.Markets.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public ArrayList<Market> getMarkets() {

        ArrayList<Market> marketList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DBContract.SQL_SELECT_MARKETS_TABLE, null);

        try {
            if (cursor.moveToFirst()) {
                do {

                    Market market = new Market();
                    market.setMic(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_MIC)));
                    market.setTapeId(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_TAPE_ID)));
                    market.setVenueName(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_VOLUME_NAME)));
                    market.setVolume(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_VOLUME)));
                    market.setTapeA(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_TAPE_A)));
                    market.setTapeB(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_TAPE_B)));
                    market.setTapeC(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_TAPE_C)));
                    market.setMarketPercent(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_IMARKET_PERCENTY)));
                    market.setLastUpdated(cursor.getString(cursor.getColumnIndex(DBContract.Markets.COLUMN_NAME_LAST_UPDATED)));

                    marketList.add(market);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return marketList;
        }
    }

    //=================  QUOTES =================

    public void bulkInserSelectedQuotestoQuotesDataTable(ArrayList<Quote> allSelectedQuotesParsed) {
        deleteQoutesTAble();
        try {
            ContentValues[] contentsArr = new ContentValues[allSelectedQuotesParsed.size()];

            for (int i = 0; i < allSelectedQuotesParsed.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(DBContract.Quotes.COLUMN_NAME_SYMBOL, allSelectedQuotesParsed.get(i).getSymbol());
                values.put(DBContract.Quotes.COLUMN_NAME_COMPAJY_NAME, allSelectedQuotesParsed.get(i).getCompanyName());
                values.put(DBContract.Quotes.COLUMN_NAME_PROMARY_EXCAHNGE, allSelectedQuotesParsed.get(i).getPrimaryExchange());
                values.put(DBContract.Quotes.COLUMN_NAME_SECTOR, allSelectedQuotesParsed.get(i).getSector());
                values.put(DBContract.Quotes.COLUMN_NAME_CALCULATION_PRICE, allSelectedQuotesParsed.get(i).getCalculationPrice());
                values.put(DBContract.Quotes.COLUMN_NAME_OPEN, allSelectedQuotesParsed.get(i).getOpen());
                values.put(DBContract.Quotes.COLUMN_NAME_OPEN_TIME, allSelectedQuotesParsed.get(i).getOpenTime());
                values.put(DBContract.Quotes.COLUMN_NAME_CLOSE, allSelectedQuotesParsed.get(i).getClose());
                values.put(DBContract.Quotes.COLUMN_NAME_CLOSE_TIME, allSelectedQuotesParsed.get(i).getCloseTime());
                values.put(DBContract.Quotes.COLUMN_NAME_HIGH, allSelectedQuotesParsed.get(i).getHigh());
                values.put(DBContract.Quotes.COLUMN_NAME_LOW, allSelectedQuotesParsed.get(i).getLow());
                values.put(DBContract.Quotes.COLUMN_NAME_LATEST_PRICE, allSelectedQuotesParsed.get(i).getLatestPrice());
                values.put(DBContract.Quotes.COLUMN_NAME_LATEST_SOURCE, allSelectedQuotesParsed.get(i).getLatestSource());
                values.put(DBContract.Quotes.COLUMN_NAME_LATEST_TIME, allSelectedQuotesParsed.get(i).getLatestTime());
                values.put(DBContract.Quotes.COLUMN_NAME_LATEST_UPDATE, allSelectedQuotesParsed.get(i).getLatestUpdate());
                values.put(DBContract.Quotes.COLUMN_NAME_LATEST_VOLUME, allSelectedQuotesParsed.get(i).getLatestVolume());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_REALTIME_PRICE, allSelectedQuotesParsed.get(i).getIexRealtimePrice());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_REALTIME_SIZE, allSelectedQuotesParsed.get(i).getIexRealtimeSize());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_LAST_UPDATE, allSelectedQuotesParsed.get(i).getIexLastUpdated());
                values.put(DBContract.Quotes.COLUMN_NAME_DELAYED_PRICE, allSelectedQuotesParsed.get(i).getDelayedPrice());
                values.put(DBContract.Quotes.COLUMN_NAME_DELAYED_PRICE_TIME, allSelectedQuotesParsed.get(i).getDelayedPriceTime());
                values.put(DBContract.Quotes.COLUMN_NAME_EXTENDED_PRICE, allSelectedQuotesParsed.get(i).getExtendedPrice());
                values.put(DBContract.Quotes.COLUMN_NAME_EXTENDED_SHNAGE, allSelectedQuotesParsed.get(i).getExtendedChange());
                values.put(DBContract.Quotes.COLUMN_NAME_EXTENDED_CHANGE_PERCENT, allSelectedQuotesParsed.get(i).getExtendedChangePercent());
                values.put(DBContract.Quotes.COLUMN_NAME_EXTENDED_PRICE_TIME, allSelectedQuotesParsed.get(i).getExtendedPriceTime());
                values.put(DBContract.Quotes.COLUMN_NAME_PREVIOUS_CLOSE, allSelectedQuotesParsed.get(i).getPreviousClose());
                values.put(DBContract.Quotes.COLUMN_NAME_CHNAGE, allSelectedQuotesParsed.get(i).getChange());
                values.put(DBContract.Quotes.COLUMN_NAME_CHANGE_PERCENT, allSelectedQuotesParsed.get(i).getChangePercent());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_MARKET_PERCENT, allSelectedQuotesParsed.get(i).getIexMarketPercent());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_VOLUME, allSelectedQuotesParsed.get(i).getIexVolume());
                values.put(DBContract.Quotes.COLUMN_NAME_AVG_TOTAL_VOLUME, allSelectedQuotesParsed.get(i).getAvgTotalVolume());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_BID_PRICE, allSelectedQuotesParsed.get(i).getIexBidPrice());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_BID_SIZE, allSelectedQuotesParsed.get(i).getIexBidSize());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_ASK_PRICE, allSelectedQuotesParsed.get(i).getIexAskPrice());
                values.put(DBContract.Quotes.COLUMN_NAME_IEX_ASK_SIZE, allSelectedQuotesParsed.get(i).getIexAskSize());
                values.put(DBContract.Quotes.COLUMN_NAME_MARKET_CUP, allSelectedQuotesParsed.get(i).getMarketCap());
                values.put(DBContract.Quotes.COLUMN_NAME_PE_RATIO, allSelectedQuotesParsed.get(i).getPeRatio());
                values.put(DBContract.Quotes.COLUMN_NAME_WEEK_52_HIGH, allSelectedQuotesParsed.get(i).getWeek52High());
                values.put(DBContract.Quotes.COLUMN_NAME_WEEK_52_LOW, allSelectedQuotesParsed.get(i).getWeek52Low());
                values.put(DBContract.Quotes.COLUMN_NAME_YTD_CHANGE, allSelectedQuotesParsed.get(i).getYtdChange());


                values.put(DBContract.Quotes.COLUMN_NAME_ROW_ID, String.valueOf(i+1));
                contentsArr[i] = values;

            }
            context.getContentResolver().bulkInsert(DBContract.Quotes.CONTENT_URI, contentsArr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteQoutesTAble(){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DBContract.Quotes.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }


    public ArrayList<Quote> getQuotes() {

        ArrayList<Quote> quotesList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DBContract.SQL_SELECT_QUOTES_TABLE, null);

        try {
            if (cursor.moveToFirst()) {
                do {

                    Quote quote = new Quote();
                    quote.setSymbol(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_SYMBOL)));
                    quote.setCompanyName(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_COMPAJY_NAME)));
                    quote.setPrimaryExchange(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_PROMARY_EXCAHNGE)));
                    quote.setSector(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_SECTOR)));
                    quote.setCalculationPrice(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_CALCULATION_PRICE)));
                    quote.setOpen(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_OPEN)));
                    quote.setOpenTime(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_OPEN_TIME)));
                    quote.setClose(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_CLOSE)));
                    quote.setCloseTime(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_CLOSE_TIME)));
                    quote.setHigh(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_HIGH)));
                    quote.setLow(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_LOW)));
                    quote.setLatestPrice(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_LATEST_PRICE)));
                    quote.setLatestSource(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_LATEST_SOURCE)));
                    quote.setLatestTime(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_LATEST_TIME)));
                    quote.setLatestUpdate(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_LATEST_UPDATE)));
                    quote.setLatestVolume(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_LATEST_VOLUME)));
                    quote.setIexRealtimePrice(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_REALTIME_PRICE)));
                    quote.setIexRealtimeSize(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_REALTIME_SIZE)));
                    quote.setIexLastUpdated(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_LAST_UPDATE)));
                    quote.setDelayedPrice(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_DELAYED_PRICE)));
                    quote.setDelayedPriceTime(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_DELAYED_PRICE_TIME)));
                    quote.setExtendedPrice(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_EXTENDED_PRICE)));
                    quote.setExtendedChange(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_EXTENDED_SHNAGE)));
                    quote.setExtendedChangePercent(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_EXTENDED_CHANGE_PERCENT)));
                    quote.setExtendedPriceTime(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_EXTENDED_PRICE_TIME)));
                    quote.setPreviousClose(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_PREVIOUS_CLOSE)));
                    quote.setChange(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_CHNAGE)));
                    quote.setChangePercent(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_CHANGE_PERCENT)));
                    quote.setIexMarketPercent(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_MARKET_PERCENT)));
                    quote.setIexVolume(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_VOLUME)));
                    quote.setAvgTotalVolume(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_AVG_TOTAL_VOLUME)));
                    quote.setIexBidPrice(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_BID_PRICE)));
                    quote.setIexBidSize(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_BID_SIZE)));
                    quote.setIexAskPrice(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_ASK_PRICE)));
                    quote.setIexAskSize(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_IEX_ASK_SIZE)));
                    quote.setMarketCap(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_MARKET_CUP)));
                    quote.setPeRatio(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_PE_RATIO)));
                    quote.setWeek52High(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_WEEK_52_HIGH)));
                    quote.setWeek52Low(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_WEEK_52_LOW)));
                    quote.setYtdChange(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_YTD_CHANGE)));

                    quote.setId(cursor.getString(cursor.getColumnIndex(DBContract.Quotes.COLUMN_NAME_ROW_ID)));

                    quotesList.add(quote);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return quotesList;
        }
    }

    //=================  NEWS =================

    public void bulkInsertNewsToNewsDataTable(ArrayList<News> newsListParsed) {
        deleteNewsTAble();
        try {
            ContentValues[] contentsArr = new ContentValues[newsListParsed.size()];

            for (int i = 0; i < newsListParsed.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(DBContract.News.COLUMN_NAME_DATE_TIME, newsListParsed.get(i).getDatetime());
                values.put(DBContract.News.COLUMN_NAME_HEAD_LINE, newsListParsed.get(i).getHeadline());
                values.put(DBContract.News.COLUMN_NAME_SOURCE, newsListParsed.get(i).getSource());
                values.put(DBContract.News.COLUMN_NAME_URL, newsListParsed.get(i).getUrl());
                values.put(DBContract.News.COLUMN_NAME_SUMARY, newsListParsed.get(i).getSummary());
                values.put(DBContract.News.COLUMN_NAME_RELATED, newsListParsed.get(i).getRelated());
                values.put(DBContract.News.COLUMN_NAME_IMAGE, newsListParsed.get(i).getImage());

                values.put(DBContract.News.COLUMN_NAME_ROW_ID, String.valueOf(i+1));

                contentsArr[i] = values;

            }
            context.getContentResolver().bulkInsert(DBContract.News.CONTENT_URI, contentsArr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteNewsTAble() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DBContract.News.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public ArrayList<News> getNews() {

        ArrayList<News> newsList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DBContract.SQL_SELECT_NEWS_TABLE, null);

        try {
            if (cursor.moveToFirst()) {
                do {

                    News news = new News();
                    news.setDatetime(cursor.getString(cursor.getColumnIndex(DBContract.News.COLUMN_NAME_DATE_TIME)));
                    news.setHeadline(cursor.getString(cursor.getColumnIndex(DBContract.News.COLUMN_NAME_HEAD_LINE)));
                    news.setSource(cursor.getString(cursor.getColumnIndex(DBContract.News.COLUMN_NAME_SOURCE)));
                    news.setUrl(cursor.getString(cursor.getColumnIndex(DBContract.News.COLUMN_NAME_URL)));
                    news.setSummary(cursor.getString(cursor.getColumnIndex(DBContract.News.COLUMN_NAME_SUMARY)));
                    news.setRelated(cursor.getString(cursor.getColumnIndex(DBContract.News.COLUMN_NAME_RELATED)));
                    news.setImage(cursor.getString(cursor.getColumnIndex(DBContract.News.COLUMN_NAME_IMAGE)));

                    news.setId(cursor.getString(cursor.getColumnIndex(DBContract.News.COLUMN_NAME_ROW_ID)));

                    newsList.add(news);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return newsList;
        }
    }

    //=================  EARNINGS =================
    public void bulkInsertEarningsToEarningsDataTable(ArrayList<Earning> earningsParsed) {
        deleteEarningsTAble();
        try {
            ContentValues[] contentsArr = new ContentValues[earningsParsed.size()];

            for (int i = 0; i < earningsParsed.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(DBContract.Earnings.COLUMN_NAME_SYMBOL, earningsParsed.get(i).getSymbol());
                values.put(DBContract.Earnings.COLUMN_NAME_ACTUAL_ESP, earningsParsed.get(i).getActualEPS());
                values.put(DBContract.Earnings.COLUMN_NAME_CONSENSUS_ESP, earningsParsed.get(i).getConsensusEPS());
                values.put(DBContract.Earnings.COLUMN_NAME_ESTIMATED_ESP, earningsParsed.get(i).getEstimatedEPS());
                values.put(DBContract.Earnings.COLUMN_NAME_ANNOUNCE_TIME, earningsParsed.get(i).getAnnounceTime());
                values.put(DBContract.Earnings.COLUMN_NAME_NUMBER_OF_ESTIMATES, earningsParsed.get(i).getNumberOfEstimates());
                values.put(DBContract.Earnings.COLUMN_NAME_EPS_SURPRISE_DOLLAR, earningsParsed.get(i).getePSSurpriseDollar());
                values.put(DBContract.Earnings.COLUMN_NAME_EPS_REPORT_DATE, earningsParsed.get(i).getePSReportDate());
                values.put(DBContract.Earnings.COLUMN_NAME_FISCA_PERIOD, earningsParsed.get(i).getFiscalPeriod());
                values.put(DBContract.Earnings.COLUMN_NAME_FISCAL_END_DATE, earningsParsed.get(i).getFiscalEndDate());
                values.put(DBContract.Earnings.COLUMN_NAME_YEAR_AGO, earningsParsed.get(i).getYearAgo());
                values.put(DBContract.Earnings.COLUMN_NAME_YEAR_AGO_CHANGE_PERCENT, earningsParsed.get(i).getYearAgoChangePercent());
                values.put(DBContract.Earnings.COLUMN_NAME_ESTIMATED_CHANGE_PERCENT, earningsParsed.get(i).getEstimatedChangePercent());
                values.put(DBContract.Earnings.COLUMN_NAME_SYMBOL_ID, earningsParsed.get(i).getSymbolId());
                values.put(DBContract.Earnings.COLUMN_NAME_ROW_ID, String.valueOf(i+1));
                contentsArr[i] = values;

            }
            context.getContentResolver().bulkInsert(DBContract.Earnings.CONTENT_URI, contentsArr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteEarningsTAble() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DBContract.Earnings.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public ArrayList<Earning> getEarnings() {

        ArrayList<Earning> earningList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DBContract.SQL_SELECT_EARNINGS_TABLE, null);

        try {
            if (cursor.moveToFirst()) {
                do {

                    Earning earning = new Earning();
                    earning.setSymbol(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_SYMBOL)));
                    earning.setActualEPS(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_ACTUAL_ESP)));
                    earning.setConsensusEPS(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_CONSENSUS_ESP)));
                    earning.setEstimatedEPS(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_ESTIMATED_ESP)));
                    earning.setAnnounceTime(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_ANNOUNCE_TIME)));
                    earning.setNumberOfEstimates(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_NUMBER_OF_ESTIMATES)));
                    earning.setePSSurpriseDollar(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_EPS_SURPRISE_DOLLAR)));
                    earning.setePSReportDate(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_EPS_REPORT_DATE)));
                    earning.setFiscalPeriod(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_FISCA_PERIOD)));
                    earning.setFiscalEndDate(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_FISCAL_END_DATE)));
                    earning.setYearAgo(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_YEAR_AGO)));
                    earning.setYearAgoChangePercent(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_YEAR_AGO_CHANGE_PERCENT)));
                    earning.setEstimatedChangePercent(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_ESTIMATED_CHANGE_PERCENT)));
                    earning.setSymbolId(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_SYMBOL_ID)));
                    earning.setId(cursor.getString(cursor.getColumnIndex(DBContract.Earnings.COLUMN_NAME_ROW_ID)));

                    earningList.add(earning);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return earningList;
        }
    }
}
