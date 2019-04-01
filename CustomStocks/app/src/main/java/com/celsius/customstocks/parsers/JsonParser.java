package com.celsius.customstocks.parsers;

import com.celsius.customstocks.datamodels.Chart;
import com.celsius.customstocks.datamodels.Earning;
import com.celsius.customstocks.datamodels.Financial;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.VolumeByVenue;
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
    public JsonParser() {
    }

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
            quote.setSymbol(String.valueOf(jsonObject.get("symbol")));
            quote.setCompanyName((String.valueOf(jsonObject.get("companyName"))));
            quote.setPrimaryExchange((String.valueOf(jsonObject.get("primaryExchange"))));
            quote.setSector((String.valueOf(jsonObject.get("sector"))));
            quote.setCalculationPrice((String.valueOf(jsonObject.get("calculationPrice"))));
            quote.setOpen((String.valueOf(jsonObject.get("open"))));
            quote.setOpenTime((String.valueOf(jsonObject.get("openTime"))));
            quote.setClose((String.valueOf(jsonObject.get("close"))));
            quote.setCloseTime((String.valueOf(jsonObject.get("closeTime"))));
            quote.setHigh((String.valueOf(jsonObject.get("high"))));
            quote.setLow((String.valueOf(jsonObject.get("low"))));
            quote.setLatestPrice((String.valueOf(jsonObject.get("latestPrice"))));
            quote.setLatestSource((String.valueOf(jsonObject.get("latestSource"))));
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
            quote.setIexVolume((String.valueOf(jsonObject.get("iexVolume"))));
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


    public ArrayList<VolumeByVenue> getVoluemeByVenueParsed(String getVolumeByVenueFromIEXResponce, String symbol) {
        JSONArray reader = null;
        ArrayList<VolumeByVenue> volumeByVenueArrayList = new ArrayList<>();

        try {
            reader = new JSONArray(getVolumeByVenueFromIEXResponce);
            for (int i = 0; i < reader.length(); i++) {
                JSONObject jsonObject = reader.getJSONObject(i);
                VolumeByVenue volumeByVenue = new VolumeByVenue();

                volumeByVenue.setSymbol(symbol);
                volumeByVenue.setVolume(String.valueOf(jsonObject.get("volume")));
                volumeByVenue.setVenue(String.valueOf(jsonObject.get("venue")));
                volumeByVenue.setVenueName(String.valueOf(jsonObject.get("venueName")));
                volumeByVenue.setMarketPercent(String.valueOf(jsonObject.get("marketPercent")));
                volumeByVenue.setAvgMarketPercent(String.valueOf(jsonObject.get("avgMarketPercent")));
                volumeByVenue.setDate(String.valueOf(jsonObject.get("date")));

                volumeByVenueArrayList.add(volumeByVenue);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return volumeByVenueArrayList;
    }

    public ArrayList<Earning> getEarningParsed(String getEarningFromIEXResponce, String symbolName) {
        JSONObject readerSymbol = null;
        JSONArray readerEarnings = null;

        ArrayList<Earning> earningArrayList = new ArrayList<>();


        try {

            readerSymbol = new JSONObject(getEarningFromIEXResponce);
            readerEarnings = new JSONObject(getEarningFromIEXResponce).getJSONArray("earnings");


            for (int i = 0; i < readerEarnings.length(); i++) {
                JSONObject jsonObject = readerEarnings.getJSONObject(i);

                Earning earning = new Earning();

                earning.setSymbolName(symbolName);


                earning.setSymbol(String.valueOf(readerSymbol.getString("symbol")));

                earning.setActualEPS(String.valueOf(jsonObject.get("actualEPS")));
                earning.setConsensusEPS(String.valueOf(jsonObject.get("consensusEPS")));
                earning.setEstimatedEPS(String.valueOf(jsonObject.get("estimatedEPS")));
                earning.setAnnounceTime(String.valueOf(jsonObject.get("announceTime")));
                earning.setNumberOfEstimates(String.valueOf(jsonObject.get("numberOfEstimates")));
                earning.setEpsSurpriseDollar(String.valueOf(jsonObject.get("EPSSurpriseDollar")));
                earning.setEpsReportDate(String.valueOf(jsonObject.get("EPSReportDate")));

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

    public ArrayList<Financial> getFinancialsParsed(String getEarningFromIEXResponce, String symbolName) {
        JSONObject readerSymbol = null;
        JSONArray readerFinancials = null;

        ArrayList<Financial> financialArrayList = new ArrayList<>();


        try {

            readerSymbol = new JSONObject(getEarningFromIEXResponce);
            readerFinancials = new JSONObject(getEarningFromIEXResponce).getJSONArray("financials");


            for (int i = 0; i < readerFinancials.length(); i++) {
                JSONObject jsonObject = readerFinancials.getJSONObject(i);

                Financial financial = new Financial();

                financial.setSymbolName(symbolName);

                financial.setSymbolName(symbolName);
                financial.setSymbol(String.valueOf(readerSymbol.getString("symbol")));

                financial.setReportDate(String.valueOf(jsonObject.get("reportDate")));
                financial.setGrossProfit(String.valueOf(jsonObject.get("grossProfit")));
                financial.setCostOfRevenue(String.valueOf(jsonObject.get("costOfRevenue")));
                financial.setOperatingRevenue(String.valueOf(jsonObject.get("operatingRevenue")));
                financial.setTotalRevenue(String.valueOf(jsonObject.get("totalRevenue")));
                financial.setOperatingIncome(String.valueOf(jsonObject.get("operatingIncome")));
                financial.setNetIncome(String.valueOf(jsonObject.get("netIncome")));
                financial.setResearchAndDevelopment(String.valueOf(jsonObject.get("researchAndDevelopment")));
                financial.setOperatingExpense(String.valueOf(jsonObject.get("operatingExpense")));
                financial.setCurrentAssets(String.valueOf(jsonObject.get("currentAssets")));
                financial.setTotalAssets(String.valueOf(jsonObject.get("totalAssets")));
                financial.setTotalLiabilities(String.valueOf(jsonObject.get("totalLiabilities")));
                financial.setCurrentCash(String.valueOf(jsonObject.get("currentCash")));
                financial.setCurrentDebt(String.valueOf(jsonObject.get("currentDebt")));
                financial.setTotalCash(String.valueOf(jsonObject.get("totalCash")));
                financial.setTotalDebt(String.valueOf(jsonObject.get("totalDebt")));
                financial.setShareholderEquity(String.valueOf(jsonObject.get("shareholderEquity")));
                financial.setCashChange(String.valueOf(jsonObject.get("cashChange")));
                financial.setCashFlow(String.valueOf(jsonObject.get("cashFlow")));
                financial.setOperatingGainsLosses(String.valueOf(jsonObject.get("operatingGainsLosses")));

                financialArrayList.add(financial);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return financialArrayList;
    }

    public ArrayList<Chart> getChartParsed(String getChartFromIEXResponce) {

        JSONArray reader = null;;

        ArrayList<Chart> chartDataArrayList = new ArrayList<>();


        try {
            reader = new JSONArray(getChartFromIEXResponce);
            for (int i = 0; i < reader.length(); i++) {
                JSONObject jsonObject = reader.getJSONObject(i);
                Chart chart = new Chart();

                chart.setDate(String.valueOf(jsonObject.get("date")));
                chart.setOpen(String.valueOf(jsonObject.get("open")));
                chart.setHigh(String.valueOf(jsonObject.get("high")));
                chart.setLow(String.valueOf(jsonObject.get("low")));
                chart.setClose(String.valueOf(jsonObject.get("close")));
                chart.setVolume(String.valueOf(jsonObject.get("volume")));
                chart.setUnadjustedVolume(String.valueOf(jsonObject.get("unadjustedVolume")));
                chart.setChange(String.valueOf(jsonObject.get("change")));
                chart.setChangePercent(String.valueOf(jsonObject.get("changePercent")));
                chart.setVwap(String.valueOf(jsonObject.get("vwap")));
                chart.setLabel(String.valueOf(jsonObject.get("label")));
                chart.setChangeOverTime(String.valueOf(jsonObject.get("changeOverTime")));

                chartDataArrayList.add(chart);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return chartDataArrayList;

    }
}
