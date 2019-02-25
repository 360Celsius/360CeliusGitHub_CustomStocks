package com.celsius.customstocks.parsers;

import com.celsius.customstocks.datamodels.Earning;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.News;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.datamodels.Symbol;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JsonParser {

    @Inject
    public JsonParser() {}

    public ArrayList<Symbol> getAllSymbolsParsed(String getSymbolsFromIEXResponce) {
        JSONArray reader = null;
        ArrayList<Symbol> symbolArrayList = new ArrayList<>();

        try {
            reader = new JSONArray(getSymbolsFromIEXResponce);
            for (int i = 0; i < reader.length(); i++) {
                JSONObject jsonObject = reader.getJSONObject(i);
                Symbol symbol = new Symbol();

                symbol.setDate(String.valueOf(jsonObject.get("date")));
                symbol.setIexId(String.valueOf(jsonObject.get("iexId")));
                symbol.setIsEnabled(String.valueOf(jsonObject.get("isEnabled")));
                symbol.setName(String.valueOf(jsonObject.get("name")));
                symbol.setSymbol(String.valueOf(jsonObject.get("symbol")));
                symbol.setType(String.valueOf(jsonObject.get("type")));

                symbolArrayList.add(symbol);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return symbolArrayList;
    }

    public ArrayList<Market> getMarketsParsed(String getMarketsFromIEXResponce) {
        JSONArray reader = null;
        ArrayList<Market> marketsArrayList = new ArrayList<>();

        try {
            reader = new JSONArray(getMarketsFromIEXResponce);
            for (int i = 0; i < reader.length(); i++) {
                JSONObject jsonObject = reader.getJSONObject(i);
                Market market = new Market();

                market.setMic(String.valueOf(jsonObject.get("mic")));
                market.setTapeId(String.valueOf(jsonObject.get("tapeId")));
                market.setVenueName(String.valueOf(jsonObject.get("venueName")));
                market.setVolume(String.valueOf(jsonObject.get("volume")));
                market.setTapeA(String.valueOf(jsonObject.get("tapeA")));
                market.setTapeB(String.valueOf(jsonObject.get("tapeB")));
                market.setTapeC(String.valueOf(jsonObject.get("tapeC")));
                market.setMarketPercent(String.valueOf(jsonObject.get("marketPercent")));
                market.setLastUpdated(String.valueOf(jsonObject.get("lastUpdated")));


                marketsArrayList.add(market);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return marketsArrayList;
    }

    public Quote getQuotesParsed(String getQuotesFromIEXResponce) {
        JSONObject jsonObject = null;
        Quote quote = new Quote();
        try {
            jsonObject = new JSONObject(getQuotesFromIEXResponce);
            quote.setSymbol(String.valueOf(jsonObject.get("symbol") ));
            quote.setCompanyName((String.valueOf(jsonObject.get("companyName"))));
            quote.setPrimaryExchange((String.valueOf(jsonObject.get("primaryExchange"))));
            quote.setSector((String.valueOf(jsonObject.get("sector"))));
            quote.setCalculationPrice((String.valueOf( jsonObject.get("calculationPrice"))));
            quote.setOpen((String.valueOf(jsonObject.get("open"))));
            quote.setOpenTime((String.valueOf(jsonObject.get("openTime"))));
            quote.setClose((String.valueOf(jsonObject.get("close"))));
            quote.setCloseTime((String.valueOf(jsonObject.get("closeTime"))));
            quote.setHigh((String.valueOf(jsonObject.get("high"))));
            quote.setLow((String.valueOf(jsonObject.get("low"))));
            quote.setLatestPrice((String.valueOf(jsonObject.get("latestPrice"))));
            quote.setLatestSource((String.valueOf( jsonObject.get("latestSource"))));
            quote.setLatestTime((String.valueOf(jsonObject.get("latestTime"))));
            quote.setLatestUpdate((String.valueOf(jsonObject.get("latestUpdate"))));
            quote.setLatestVolume((String.valueOf(jsonObject.get("latestVolume"))));
            quote.setIexRealtimePrice((String.valueOf(jsonObject.get("iexRealtimePrice"))));
            quote.setIexRealtimeSize((String.valueOf(jsonObject.get("iexRealtimeSize"))));
            quote.setIexLastUpdated((String.valueOf(jsonObject.get("iexLastUpdated"))));
            quote.setDelayedPrice((String.valueOf(jsonObject.get("delayedPrice"))));
            quote.setDelayedPriceTime((String.valueOf(jsonObject.get("delayedPriceTime"))));
            quote.setExtendedPrice((String.valueOf(jsonObject.get("extendedPrice"))));
            quote.setExtendedChange((String.valueOf(jsonObject.get("extendedChange"))));
            quote.setExtendedChangePercent((String.valueOf(jsonObject.get("extendedChangePercent"))));
            quote.setExtendedPriceTime((String.valueOf(jsonObject.get("extendedPriceTime"))));
            quote.setPreviousClose((String.valueOf(jsonObject.get("previousClose"))));
            quote.setChange((String.valueOf(jsonObject.get("change"))));
            quote.setChangePercent((String.valueOf(jsonObject.get("changePercent"))));
            quote.setIexMarketPercent((String.valueOf(jsonObject.get("iexMarketPercent"))));
            quote.setIexVolume((String.valueOf( jsonObject.get("iexVolume"))));
            quote.setAvgTotalVolume((String.valueOf(jsonObject.get("avgTotalVolume"))));
            quote.setIexBidPrice((String.valueOf(jsonObject.get("iexBidPrice"))));
            quote.setIexBidSize((String.valueOf(jsonObject.get("iexBidSize"))));
            quote.setIexAskPrice((String.valueOf(jsonObject.get("iexAskPrice"))));
            quote.setIexAskSize((String.valueOf(jsonObject.get("iexAskSize"))));
            quote.setMarketCap((String.valueOf(jsonObject.get("marketCap"))));
            quote.setPeRatio((String.valueOf(jsonObject.get("peRatio"))));
            quote.setWeek52High((String.valueOf(jsonObject.get("week52High"))));
            quote.setWeek52Low((String.valueOf(jsonObject.get("week52Low"))));
            quote.setYtdChange((String.valueOf(jsonObject.get("ytdChange"))));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return quote;
    }


    public ArrayList<News> getNewsParsed(String getNewsFromIEXResponce) {
        JSONArray reader = null;
        ArrayList<News> newsArrayList = new ArrayList<>();

        try {
            reader = new JSONArray(getNewsFromIEXResponce);
            for (int i = 0; i < reader.length(); i++) {
                JSONObject jsonObject = reader.getJSONObject(i);
                News news = new News();

                news.setDatetime(String.valueOf(jsonObject.get("datetime")));
                news.setHeadline(String.valueOf(jsonObject.get("headline")));
                news.setSource(String.valueOf(jsonObject.get("source")));
                news.setUrl(String.valueOf(jsonObject.get("url")));
                news.setSummary(String.valueOf(jsonObject.get("summary")));
                news.setRelated(String.valueOf(jsonObject.get("related")));
                news.setImage(String.valueOf(jsonObject.get("image")));

                newsArrayList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return newsArrayList;
    }

    public ArrayList<Earning> getEarningParsed(String getEarningFromIEXResponce) {
        JSONObject readerSymbol = null;
        JSONArray readerEarnings = null;

        ArrayList<Earning> earningArrayList = new ArrayList<>();



        try {

            readerSymbol = new JSONObject(getEarningFromIEXResponce);
            readerEarnings = new JSONObject(getEarningFromIEXResponce).getJSONArray("earnings");



            for (int i = 0; i < readerEarnings.length(); i++) {
                JSONObject jsonObject = readerEarnings.getJSONObject(i);

                Earning earning = new Earning();

                earning.setSymbol(String.valueOf(readerSymbol.getString("symbol")));

                earning.setActualEPS(String.valueOf(jsonObject.get("actualEPS")));
                earning.setConsensusEPS(String.valueOf(jsonObject.get("consensusEPS")));
                earning.setEstimatedEPS(String.valueOf(jsonObject.get("estimatedEPS")));
                earning.setAnnounceTime(String.valueOf(jsonObject.get("announceTime")));
                earning.setNumberOfEstimates(String.valueOf(jsonObject.get("numberOfEstimates")));
                earning.setePSSurpriseDollar(String.valueOf(jsonObject.get("EPSSurpriseDollar")));
                earning.setePSReportDate(String.valueOf(jsonObject.get("EPSReportDate")));

                earning.setFiscalPeriod(String.valueOf(jsonObject.get("fiscalPeriod")));
                earning.setFiscalEndDate(String.valueOf(jsonObject.get("fiscalEndDate")));
                earning.setYearAgo(String.valueOf(jsonObject.get("yearAgo")));
                earning.setYearAgoChangePercent(String.valueOf(jsonObject.get("yearAgoChangePercent")));
                earning.setEstimatedChangePercent(String.valueOf(jsonObject.get("estimatedChangePercent")));
                earning.setSymbolId(String.valueOf(jsonObject.get("symbolId")));

                earningArrayList.add(earning);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return earningArrayList;
    }


}
