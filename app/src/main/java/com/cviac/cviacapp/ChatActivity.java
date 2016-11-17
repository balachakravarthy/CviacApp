package com.cviac.cviacapp;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cviac.adapter.ChatMessageAdapter;
import com.cviac.adapter.ColleguesAdapter;
import com.cviac.datamodel.ChatMessage;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Build;

public class ChatActivity extends Activity {
	static EditText sendedit;
	static View rootView;
	ActionBar actionBar;
	static ActionBar mActionBar;
	private List<ChatMessage> chats;
	private ChatMessageAdapter chatAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		
		ListView lv=(ListView)findViewById(R.id.listViewChat);
		chats = new ArrayList<ChatMessage>();
		chatAdapter = new ChatMessageAdapter(chats,this);
		lv.setDivider(null);
	    lv.setAdapter(chatAdapter);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
		final EditText msgview=(EditText)findViewById(R.id.editTextsend);
		final ImageButton b = (ImageButton)findViewById(R.id.sendbutton);

		b.setOnClickListener(new OnClickListener() {

	@Override
	public void onClick(View v) {
		
			String msg=msgview.getText().toString();
			if(msg.length()!=0)
			{
			ChatMessage mgsopj=new ChatMessage();
			mgsopj.setMsg(msg);
			mgsopj.setIn(false);
			mgsopj.setCtime(new Date());
			chats.add(mgsopj);
			msgview.getText().clear();
			chatAdapter.notifyDataSetChanged();
			}
		
	}
});
	}
	





	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			rootView = inflater.inflate(R.layout.fragment_chat, container, false);

			return rootView;
		}
	}

}
