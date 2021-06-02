     package com.example.top10download

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.sql.Connection

class MainActivity : AppCompatActivity() {
    private val  TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate Called")
        val downloadData=DownloadData()
        downloadData.execute("URL Goes here")
        Log.d(TAG,"onCreate: Done")
    }

    companion object {
        private class DownloadData : AsyncTask<String, Void, String>(){
            private val TAG="DownloadData"
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                Log.d(TAG,"onPostExecute: Parameter is $result")
            }
            override fun doInBackground(vararg url: String?): String {
            Log.d(TAG,"doInBackground: starts with ${url[0]}")
                val rssFeed=downloadXml(url[0])
                if(rssFeed.isEmpty()){
                    Log.e(TAG,"doInBackground: error dowloading")
                }
                return rssFeed
            }
            private fun downloadXml(urlPath:String?):String{
                val xmlResult=StringBuilder()
                try{
                    val url= URL(urlPath)
                    val connection:HttpURLConnection=url.openConnection() as HttpURLConnection
                    val response=connection.responseCode
                    Log.d(TAG,"downloadXML: The response code was $response")

//            val inputStream=connection.inputStream
//            val inputStreamReader=InputStreamReader(inputStream)
//            val reader=BufferedReader(inputStreamReader)
                    val reader=BufferedReader(InputStreamReader(connection.inputStream))
                    val inputBuffer=CharArray(400)
                    var  charsread=0
                    while (charsread>=0){
                        charsread=reader.read(inputBuffer)
                        if(charsread>0){
                            xmlResult.append(String(inputBuffer,0,charsread))
                        }
                    }
                    reader.close()
                    Log.d(TAG,"Received ${xmlResult.length} bytes")
                    return xmlResult.toString()

                }catch (e:MalformedURLException){
                    Log.e(TAG,"downloadXML: Invalid URL ${e.message}")
                }catch (e:IOException){
                    Log.e(TAG,"downloadXML: IO Exception reading data: ${e.message}")
                }catch (e:Exception){
                    Log.e(TAG,"Unknown error ${e.message}")
                }
                return ""
            }

        }
    }

}