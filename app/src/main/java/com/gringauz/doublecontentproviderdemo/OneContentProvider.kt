package com.gringauz.doublecontentproviderdemo

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Handler
import android.os.HandlerThread
import android.util.Log

class OneContentProvider: ContentProvider() {
    private lateinit var handlerThread: HandlerThread
    private lateinit var handler: Handler

    override fun onCreate(): Boolean {
        Log.e("LOGGERR", "OneContentProvider.onCreate ${Thread.currentThread().name}")
        handlerThread = HandlerThread("MegaHandlerThread_1")
        handlerThread.start()
        handler = Handler(handlerThread.looper)
        handler.post {
            val uri = Uri.parse("content://com.gringauz.doublecontentproviderdemo.TwoContentProvider")
            context!!.contentResolver.query(uri, null, null, null, null)
        }
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        Log.e("LOGGERR", "OneContentProvider.query ${Thread.currentThread().name}")
        return null
    }

    override fun getType(uri: Uri): String? {
        Log.e("LOGGERR", "OneContentProvider.getType ${Thread.currentThread().name}")
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        Log.e("LOGGERR", "OneContentProvider.insert ${Thread.currentThread().name}")
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        Log.e("LOGGERR", "OneContentProvider.delete ${Thread.currentThread().name}")
        return 0
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        Log.e("LOGGERR", "OneContentProvider.update ${Thread.currentThread().name}")
        return 0
    }
}