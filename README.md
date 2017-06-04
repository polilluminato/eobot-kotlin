# eobot-kotlin

![Eobot API](https://www.eobot.com/eobotlogo.png "Eobot.com")

This Kotlin class provides a implementation for the API of the Cloud mining and Bitcoin mining [Eobot.com](https://www.eobot.com/)   
> Eobot is the easiest, cheapest, and best way to get or mine Bitcoin, Litecoin, BlackCoin, Namecoin, Dogecoin, Dash, Reddcoin, BitShares, CureCoin, StorjcoinX, Monero, Voxels, Lumens, Bytecoin, Peercoin, NXT, MaidSafeCoin, Ethereum, and Factom. Whether or not you use our Cloud Mining or your own hardware, you can mine any cryptocurrency, regardless if it is based on a SHA-256 or Scrypt algorithm.

and you can use it in an Android App.
The API that Eobot expose are listed in this page: [Eobot Developers](https://www.eobot.com/developers).

## Requirements

This kotlin class uses [Fast-Android-Networking](https://github.com/amitshekhariitbhu/Fast-Android-Networking) to make the request so, you have to include it in your Android App Project. As described in the Fast-Android-Networking [Readme.md](https://github.com/amitshekhariitbhu/Fast-Android-Networking/blob/master/README.md) add this in your build.gradle
```groovy
compile 'com.amitshekhar.android:android-networking:1.0.0'
```
Add internet permission in manifest if already not present
```xml
<uses-permission android:name="android.permission.INTERNET" />
```
Then initialize it in onCreate() Method of application class, in my case I use this custom App.class:

```java
public class App extends Application {

    private static Context mContext;
    public static Context getContext(){
        return mContext;
    }

    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
    }
}
```
After that you can put the EobotAPI.kt class wherever you want.

## Usage

To use the class instantiate it and call methods, for example
```java
public class MainActivity extends AppCompatActivity {

    private EobotAPI mRequest = new EobotAPI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call the getBalances Method
        mRequest.getBalances(userId,new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("RESPONSE","Response: " + response.toString());
            }
            @Override
            public void onError(ANError anError) {}
        });
    
    }     

}
```
And the result must be something like this
```
{
  "Total":"6.10402110","BTC":"0.00000000","ETH":"0.00000000",
  ...
  "GHS":"0.00000000","GHS2":"0.00000000","SCRYPT":"0.00000000",
  "BPPD":"0.00000000","PPD":"0.00000000"
}
```

## API Implmentation

Every API uses as input all the parameters required by Eobot, in the same order as described in the developers page, and return a JSONObject.

#### Get Balances
Returns total account value followed by cryptocurrency balances. Pass in querystring userId.
```kotlin
fun getBalances(userId : String, listener : JSONObjectRequestListener) : Unit {}
```
#### Get Mining Mode
Returns the cryptocurrency you are currently mining. Pass in querystring UserID.
```kotlin
fun getMiningMode(userId : String, listener : JSONObjectRequestListener) : Unit {}
```

#### Get Speed
Returns the mining and cloud speeds. Pass in querystring UserID.
```kotlin
fun getSpeed(userId : String, listener : JSONObjectRequestListener) : Unit {}
```

#### Get Deposit Address
Returns a deposit wallet address for specified cryptocurrency. Pass in querystring UserID and deposit type (BTC, ETH, LTC, etc.).
```kotlin
fun getDepositAddress(userId : String, depositType : String, listener : JSONObjectRequestListener) : Unit {}
```

#### Get UserID
Returns the UserID. Pass in querystring (or post parameters) email and password/API Key.
```kotlin
fun getUserID(email : String, password : String, listener : JSONObjectRequestListener) : Unit {}
```

#### Set Mining Mode
Programmatically set your mining mode. Pass in querystring (or post parameters) UserID, email, password/API Key, and mining mode (BTC, ETH, LTC, etc.).
```kotlin
fun setMiningMode(userId : String, email : String, 
                    password : String, miningMode : String, 
                    listener : JSONObjectRequestListener) : Unit {}
```

#### Set Automatic Withdraw
Programmatically set an automatic withdraw. Pass in querystring (or post parameters) UserID, email, password/API Key, automatic withdraw type (BTC, ETH, LTC, etc.), amount, and wallet address.
```kotlin
fun setAutomaticWithdraw(userId : String, email : String, 
                                password : String, currency : String, 
                                amount : String, walletAddress : String, 
                                listener : JSONObjectRequestListener) : Unit {}
```

#### Manual Withdraw
Performs a one-time manual withdraw. Pass in querystring (or post parameters) UserID, email, password/API Key, manual withdraw type (BTC, ETH, LTC, etc.), amount, and wallet address.
```kotlin
fun manualWithdraw(userId : String, email : String, 
                                password : String, currency : String, 
                                amount : String, walletAddress : String, 
                                listener : JSONObjectRequestListener) : Unit {}
```

#### Buy Cloud with Cryptocurrency
Programmatically buy Cloud. Pass in querystring (or post parameters) UserID, email, password/API Key, cloud type (GHS or GHS4 or SCRYPT), cryptocurrency source (BTC, ETH, LTC, etc.), and cryptocurrency amount.
```kotlin
fun buyCloudWithCryptocurrency(userId : String, email : String, 
                                        password : String, currencyFrom : String, 
                                        amount : String, cloudType : String, 
                                        listener : JSONObjectRequestListener) : Unit {}
```

### Disclaimer
I'm **not** associated or **related** with Eobot.com, this is my implementation based on the public API. I'm **not** responsible if **you** lose money using this library because this is a Kotlin Class for the Eobot.com Public API.

## License

GPL-3.0. See [gpl-3.0-standalone.html](http://www.gnu.org/licenses/gpl-3.0-standalone.html) for details.