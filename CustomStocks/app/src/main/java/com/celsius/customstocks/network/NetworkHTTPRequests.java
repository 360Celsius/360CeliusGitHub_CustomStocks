package com.celsius.customstocks.network;

public class NetworkHTTPRequests {

    private static NetworkHTTPConnection networkHTTPConnection;
    private static NetworkHttpAPIurlConst networkHttpAPIurlConst;


    private static NetworkHTTPRequests _instance;



    public static NetworkHTTPRequests getInstance()
    {
        if (_instance == null)
        {
            _instance = new NetworkHTTPRequests();
        }
        return _instance;
    }

    public NetworkHTTPRequests() {
        this.networkHTTPConnection = NetworkHTTPConnection.getInstance();
        this.networkHttpAPIurlConst = NetworkHttpAPIurlConst.getInstance();
    }


   public String getSymbolsFromIEX(){
        String responce = null;
        String url = networkHttpAPIurlConst.getSymbolsListURL();
        responce = networkHTTPConnection.getHttp(url);
        return responce;
   }
}
