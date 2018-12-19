package com.darkhorse.mvvmframe.http

import android.content.Context
import com.darkhorse.mvvmframe.http.converter.BaseConvert
import com.darkhorse.mvvmframe.http.minterface.IDoubleToken
import com.darkhorse.mvvmframe.http.minterface.ISingleToken
import com.darkhorse.mvvmframe.http.converter.BaseConverterFactory

import com.darkhorse.mvvmframe.http.client.HttpClient
import com.darkhorse.mvvmframe.http.client.RetrofitClient
import com.darkhorse.mvvmframe.http.minterface.ILanguage
import com.darkhorse.mvvmframe.http.interceptor.*

import java.util.HashMap

import okhttp3.Interceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * Created by DarkHorse on 2018/2/4.
 */

object HttpHelper {

    private var mRetrofit: Retrofit? = null
    private var hasSetUrl = false

    private val mInterceptorList by lazy {
        ArrayList<Interceptor>()
    }
    private var mMulUrlInterceptor: MulUrlInterceptor? = null
    private var mNetWorkCheckInterceptor: NetWorkCheckInterceptor? = null
    private var mLanguageInterceptor: LanguageInterceptor? = null
    private var mTokenInterceptor: TokenInterceptor? = null
    private var mDoubleTokenInterceptor: DoubleTokenInterceptor? = null
    private var mRetryInterceptor: RetryInterceptor? = null

    /**
     * 添加BaseUrl
     */
    fun addBaseUrl(url: String): HttpHelper {
        if (!hasSetUrl) {
            RetrofitClient.retrofitBuilder.baseUrl(url)
            hasSetUrl = true
        }
        return this
    }

    /**
     * 通过添加@Header，实现多种BaseUrl的支持
     */
    fun supportMulBaseUrl(urlMap: HashMap<String, String>): HttpHelper {
        if (!hasSetUrl) {
            mMulUrlInterceptor = MulUrlInterceptor(urlMap)
            hasSetUrl = true
        }
        return this
    }

    /**
     * 添加国际化请求机制
     */
    fun supportLanguage(iLanguage: ILanguage): HttpHelper {
        if (mLanguageInterceptor == null) {
            mLanguageInterceptor = LanguageInterceptor(iLanguage)
        }
        return this
    }

    /**
     * 添加单Token请求机制
     */
    fun supportSingleToken(iSingleToken: ISingleToken): HttpHelper {
        if (mDoubleTokenInterceptor == null) {
            mTokenInterceptor = TokenInterceptor(iSingleToken)
        }
        return this

    }

    /**
     * 添加双Token请求机制
     */
    fun supportDoubleToken(iDoubleToken: IDoubleToken): HttpHelper {
        if (mTokenInterceptor == null) {
            mDoubleTokenInterceptor = DoubleTokenInterceptor(iDoubleToken)
        }
        return this
    }

    /**
     * 添加网络检查支持
     */
    fun supportNetworkCheck(context: Context, errorMethod: () -> Unit): HttpHelper {
        mNetWorkCheckInterceptor = NetWorkCheckInterceptor(context, errorMethod)
        return this
    }

    /**
     * 添加网络重试支持
     */
    fun supportRetry(hint: String) {
        mRetryInterceptor = RetryInterceptor(hint)
    }

    /**
     * 添加Cookie支持
     */
    fun addCookieAutoManager(context: Context): HttpHelper {
        HttpClient.addCookieJar(context)
        return this
    }

    /**
     *添加自定义转换器
     */
    fun setConvert(converter: BaseConvert): HttpHelper {
        RetrofitClient.retrofitBuilder.addConverterFactory(BaseConverterFactory(converter))
        return this
    }

    /**
     * 添加拦截器
     */
    fun addInterceptor(interceptor: Interceptor): HttpHelper {
        mInterceptorList.add(interceptor)
        return this
    }

    /**
     * 设置超时时长
     */
    fun setTimeout(connectTimeout: Long, readTimeout: Long, timeUnit: TimeUnit): HttpHelper {
        HttpClient.setTimeout(connectTimeout, readTimeout, timeUnit)
        return this
    }


    fun init() {
        if (mNetWorkCheckInterceptor != null) {
            HttpClient.addInterceptor(mNetWorkCheckInterceptor!!)
        }
        if (mMulUrlInterceptor != null) {
            HttpClient.addInterceptor(mMulUrlInterceptor!!)
        }
        if (mLanguageInterceptor != null) {
            HttpClient.addInterceptor(mLanguageInterceptor!!)
        }
        if (mTokenInterceptor != null) {
            HttpClient.addInterceptor(mTokenInterceptor!!)
        }
        if (mDoubleTokenInterceptor != null) {
            HttpClient.addInterceptor(mDoubleTokenInterceptor!!)
        }

        for (i in mInterceptorList) {
            HttpClient.addInterceptor(i)
        }

        if (mRetryInterceptor != null) {
            HttpClient.addInterceptor(mRetryInterceptor!!)
        }
        RetrofitClient.retrofitBuilder.client(HttpClient.mBuilder.build())
        mRetrofit = RetrofitClient.retrofit
    }

    fun <T> getService(cls: Class<T>): T {
        return mRetrofit!!.create(cls)
    }

}
