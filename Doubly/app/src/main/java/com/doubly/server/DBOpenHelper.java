package com.doubly.server;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.doubly.R;
import com.doubly.object.ChatMessage;
import com.doubly.object.Interest;
import com.doubly.object.MainChatMessage;
import com.doubly.utils.Session;
import com.doubly.utils.SessionKeys;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by darkbobo on 12/13/15.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	SQLiteDatabase db;

	public DBOpenHelper(Context context) {
		super(context, context.getResources().getString(R.string.database_name), null, DATABASE_VERSION);
		onCreate(getWritableDatabase());
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		this.db = db;
		init();
		deleteTableData();
		initTestData();
	}

	public ArrayList<MainChatMessage> getChatMessageGroupList(){
		StringBuilder sqlA = new StringBuilder();
		sqlA.setLength(0);
		sqlA.append("SELECT ");
		// display date/time, name/age/gender, most recent message snippet
		sqlA.append("   Users.Name ");
		sqlA.append(" , Users.DOB ");
		sqlA.append(" , Users.Gender ");
		sqlA.append(" , Messages.TimeCreated ");
		sqlA.append(" , Messages.MessageText ");
		sqlA.append(" , Messages.ReceiverID ");
		//sqlA.append(" , InterestCount ");
		sqlA.append("FROM Users ");
		sqlA.append("INNER JOIN Messages ON Users.UserID = Messages.ReceiverID ");
		sqlA.append("GROUP BY Users.Name ");

		Cursor model = db.rawQuery(sqlA.toString(), null);
		sqlA.setLength(0);

		ArrayList<MainChatMessage> messages = new ArrayList<>();
		if(model.moveToFirst()){
			while(!model.isAfterLast()){
				MainChatMessage message = new MainChatMessage();
				message.setName(model.getString(model.getColumnIndex("Name")));
				message.setDOB(new Date(model.getLong(model.getColumnIndex("DOB"))));
				message.setTimeCreated(new Date(model.getLong(model.getColumnIndex("TimeCreated"))));
				message.setGender(model.getString(model.getColumnIndex("Gender")));
				message.setReceiverID(model.getInt(model.getColumnIndex("ReceiverID")));
				messages.add(message);
			}
		}
		return messages;
	}

	public ArrayList<ChatMessage> getChatMessageBySender(int senderID){
		StringBuilder sqlA = new StringBuilder();
		sqlA.setLength(0);
		sqlA.append("SELECT ");
		sqlA.append("   Users.Name ");
		sqlA.append(" , Users.UserID ");
		sqlA.append(" , Messages.MessageID ");
		sqlA.append(" , Messages.MessageText ");
		sqlA.append(" , Messages.TimeCreated ");
		sqlA.append(" , Messages.SenderID ");
		sqlA.append(" , Messages.ReceiverID ");
		sqlA.append("FROM Messages ");
		sqlA.append("WHERE Messages.ReceiverID = " + senderID + " ");
		sqlA.append("   OR Messages.SenderID = " + 1 + " ");
		sqlA.append("INNER JOIN Users ON Messages.ReceiverID = Users.UserID ");
		sqlA.append("ORDER BY Messages.TimeCreated ");
		ArrayList<ChatMessage> messages = new ArrayList<>();
		Cursor model = db.rawQuery(sqlA.toString(), null);
		sqlA.setLength(0);

		if(model.moveToFirst()){
			while(!model.isAfterLast()){
				ChatMessage message = new ChatMessage();
				message.setSenderID(model.getInt(model.getColumnIndex("SenderID")));
				message.setReceiverID(model.getInt(model.getColumnIndex("ReceiverID")));
				message.setMessageID(model.getInt(model.getColumnIndex("MessageID")));
				message.setMessageText(model.getString(model.getColumnIndex("MessageText")));
				message.setTimeCreated(model.getLong(model.getColumnIndex("TimeCreated")));
				messages.add(message);
			}
		}
		return messages;
	}

	public ArrayList<Interest> getInterests(){
		StringBuilder sqlA = new StringBuilder();
		sqlA.setLength(0);
		sqlA.append("SELECT ");
		sqlA.append("   Interests.InterestName ");
		sqlA.append(" , UserInterests.InterestID ");
		sqlA.append(" , UserIntersts.UserID ");
		sqlA.append("FROM UserInterests ");
		sqlA.append("INNER JOIN Interests ON Interests.InterestID ");
		sqlA.append("WHERE UserInterests.UserID = " + Session.getInt(SessionKeys.PREFFS_USER_ID) + " ");
		Cursor model = db.rawQuery(sqlA.toString(), null);
		sqlA.setLength(0);

		ArrayList<Interest> interests = new ArrayList<>();
		if(model.moveToFirst()){
			while(!model.isAfterLast()){
				Interest interest = new Interest();
				interest.setInterestID(model.getInt(model.getColumnIndex("InterestID")));
				interest.setInterestTitle(model.getString(model.getColumnIndex("InterestName")));
			}
		}
		return interests;
	}


	public void init(){
		StringBuilder sqlA = new StringBuilder();
		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS Users ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , UserID INTEGER ");
		sqlA.append(" , UserName TEXT ");
		sqlA.append(" , DOB DATETIME");
		sqlA.append(" , Gender TEXT ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS UsersFriends ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , UserID INTEGER ");
		sqlA.append(" , FriendUserID INTEGER ");
		sqlA.append(" , FriendStatus TEXT ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS UserInterests ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append("   UserID INTEGER ");
		sqlA.append(" , InterestID INTEGER ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS Interests ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , InterestID INTEGER ");
		sqlA.append(" , InterestName TEXT ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS Messages ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , MessageID INTEGER ");
		sqlA.append(" , SenderID INTEGER ");
		sqlA.append(" , ReceiverID INTEGER ");
		sqlA.append(" , MessageText TEXT ");
		sqlA.append(" , TimeCreated DATETIME ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS GPS ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , UserID INTEGER ");
		sqlA.append(" , Latitude REAL ");
		sqlA.append(" , Longitude REAL ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
	}

	public void initTestData(){
		StringBuilder sqlA = new StringBuilder();
		sqlA.setLength(0);
		sqlA.append("INSERT INTO Users ");
		sqlA.append("( ");
		sqlA.append("   UserID ");
		sqlA.append(" , UserName ");
		sqlA.append(" , DOB ");
		sqlA.append(" , Gender ");
		sqlA.append(") ");
		sqlA.append(" VALUES ");
		sqlA.append("( ");
		sqlA.append("   1, 'Jim', " + new Date(1988, 11, 6) + ", " + "'M' ");
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   2, 'Pam', " + new Date(1991, 11, 11).getTime() + ", 'F' ");
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   3, 'Bill', " + new Date(1960, 2, 14).getTime() + ", 'M' ");
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   4, 'Arai', " + new Date(1960, 10, 17).getTime() + ", 'F' ");
		sqlA.append(") ");
		db.execSQL(sqlA.toString());
		sqlA.setLength(0);

		sqlA.append("INSERT INTO Interests ");
		sqlA.append("( ");
		sqlA.append("   InterestID ");
		sqlA.append(" , InterestName ");
		sqlA.append(") ");
		sqlA.append(" VALUES ");
		sqlA.append("( ");
		sqlA.append("   1, 'dog' ");
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   2, 'cat' ");
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   3, 'pen' ");
		sqlA.append(") ");
		db.execSQL(sqlA.toString());
		sqlA.setLength(0);

		sqlA.append("INSERT INTO Messages ");
		sqlA.append("( ");
		sqlA.append("   MessageID ");
		sqlA.append(" , SenderID ");
		sqlA.append(" , ReceiverID ");
		sqlA.append(" , MessageText ");
		sqlA.append(" , TimeCreated ");
		sqlA.append(") ");
		sqlA.append(" VALUES ");
		sqlA.append("( ");
		sqlA.append("   1, 1, 2, 'hello', " + new Date().getTime() + " ");
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   2, 2, 1, 'hello to you to', " + new Date().getTime() + " ");
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   3, 1, 2, 'i think you are cute', " + new Date().getTime() + " ");
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   4, 1, 3, 'your mother', " + new Date().getTime());
		sqlA.append("), ");
		sqlA.append("( ");
		sqlA.append("   5, 3, 1, 'what about that slut?', " + new Date().getTime() + " ");
		sqlA.append(") ");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);

	}

	public void deleteTableData(){
		db.execSQL("DELETE FROM Users;");
		db.execSQL("DELETE FROM Interests;");
		db.execSQL("DELETE FROM Messages;");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}


}
