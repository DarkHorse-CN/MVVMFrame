package com.darkhorse.mvvmframe.http.interceptor

import com.darkhorse.mvvmframe.http.minterface.ILanguage
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Description:
 * Created by DarkHorse on 2018/5/16.
 */
class LanguageInterceptor(private val iInternational: ILanguage) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response? {
        val request = chain.request()
        val builder = request.newBuilder()
        builder.addHeader(iInternational.getLanguageKey(), iInternational.getLanguage())
        return chain.proceed(builder.build())
    }
}
