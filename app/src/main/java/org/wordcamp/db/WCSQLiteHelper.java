package org.wordcamp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aagam on 27/1/15.
 */
public class WCSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "wordcamp.central";
    private static final int DB_VERSION = 1;
    public static final String TABLE_WC = "wordcamp";
    private static final String DB_CREATE_WORDCAMP = "create table wordcamp ( wcid integer primary key," +
            " title text, fromdate text, todate text, lastscannedgmt text, gsonobject text, url text," +
            " featuredImageUrl text, mywc INTEGER DEFAULT 0); ";

    public static final String DB_CREATE_SPEAKER = "create table speaker ( wcid integer, name text, " +
            "speaker_id int, speaker_bio text, postid int, featuredimage text, lastscannedgmt text," +
            " gsonobject text, gravatar text, PRIMARY KEY ( wcid, postid) ); ";

    public static final String DB_CREATE_SESSION = "create table session ( wcid integer, title text, " +
            "time int, postid int, location text, category text, " +
            "lastscannedgmt text, gsonobject text, mysession INTEGER DEFAULT 0, PRIMARY KEY ( wcid, postid) ); ";

    public static final String DB_CREATE_SPEAKER_SESSION = "create table speakersessions ( wcid integer," +
            "speakerid integer, sessionid integer, PRIMARY KEY (wcid, speakerid, sessionid) ); ";

    public static final String DB_CREATE_NOTIFICATION = "create table notification ( _id integer primary key autoincrement," +
            " type text, title text, descr text, link text, read integer DEFAULT 0 ); ";



    public WCSQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE_WORDCAMP);
        db.execSQL(DB_CREATE_SPEAKER);
        db.execSQL(DB_CREATE_SESSION);
        db.execSQL(DB_CREATE_SPEAKER_SESSION);
        db.execSQL(DB_CREATE_NOTIFICATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
