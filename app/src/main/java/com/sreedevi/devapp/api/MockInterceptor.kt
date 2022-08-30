package com.sreedevi.devapp.api

import com.sreedevi.devapp.constants.ApiUrls
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor(private val baseUrl: String) : Interceptor {

    private val  MOCK_LOGIN =  "{\n" +
            "  \"status\": \"SUCCESS\",\n" +
            "  \"code\": \"200\",\n" +
            "  \"message\": \"You are successfully Logged in\",\n" +
            "  \"data\": {\n" +
            "    \"user_id\": \"4\",\n" +
            "    \"name\": \"Haritha\",\n" +
            "    \"school_id\": \"1\",\n" +
            "    \"auth_token\": \"68a74d03ee680128b13bf57bfc33104032dd617b832f63147fb7de9c0a42b314\"\n" +
            "  }\n" +
            "}"

    override fun intercept(chain: Interceptor.Chain): Response {
        var responseString : String? = null
        val response : Response?
        val uri = chain.request().url.toUri()
        when{
           /* uri.toString().startsWith(baseUrl+ApiUrls.LOGIN)->{
                responseString=MOCK_LOGIN

            }*/

        }
        responseString?.let {
            response = Response.Builder()
                .code(200)
                .message(it)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(it.toByteArray().toResponseBody("application/json".toMediaTypeOrNull()))
                .addHeader("content-type","application/json")
                .build()
            return response
        }
        return chain.proceed(chain.request())
    }
}