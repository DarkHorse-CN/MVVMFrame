package com.darkhorse.mvvmframe.wrapper

import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.os.LocaleList
import com.darkhorse.mvvmframe.utils.AppManager
import java.util.*


class LanguageContextWrapper(base: Context) : ContextWrapper(base) {

    companion object {
        fun wrap(context: Context, newLocale: Locale): ContextWrapper {
            var mContext = context
            val res = mContext.resources;
            val configuration = res.configuration;

            mContext = if (AppManager.greaterThanSdkVersion(Build.VERSION_CODES.N)) {
                configuration.setLocale(newLocale);
                val localeList = LocaleList(newLocale);
                LocaleList.setDefault(localeList);
                configuration.locales = localeList;
                mContext.createConfigurationContext(configuration);
            } else {
                configuration.setLocale(newLocale);
                mContext.createConfigurationContext(configuration);
            }
            return ContextWrapper(mContext);
        }
    }
}
