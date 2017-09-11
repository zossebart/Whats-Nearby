package com.teester.mapquestions;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Details about the specific question
 */

public class QuestionObject implements Parcelable {

	private int id;
	private int question;
	private int icon;
	private int color;
	private String tag;
	private String answer_yes;
	private String answer_no;
	private String answer_unsure;

	public QuestionObject(int id, int question, int icon, int color, String tag, String answer_yes, String answer_no, String answer_unsure) {
		this.id = id;
		this.question = question;
		this.icon = icon;
		this.color = color;
		this.tag = tag;
		this.answer_yes = answer_yes;
		this.answer_no = answer_no;
		this.answer_unsure = answer_unsure;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAnswer_yes() {
		return answer_yes;
	}

	public void setAnswer_yes(String answer_yes) {
		this.answer_yes = answer_yes;
	}

	public String getAnswer_no() {
		return answer_no;
	}

	public void setAnswer_no(String answer_no) {
		this.answer_no = answer_no;
	}

	public String getAnswer_unsure() {
		return answer_unsure;
	}

	public void setAnswer_unsure(String answer_unsure) {
		this.answer_unsure = answer_unsure;
	}

	protected QuestionObject(Parcel in) {
		id = in.readInt();
		question = in.readInt();
		icon = in.readInt();
		color = in.readInt();
		tag = in.readString();
		answer_yes = in.readString();
		answer_no = in.readString();
		answer_unsure = in.readString();
	}

	public static final Creator<QuestionObject> CREATOR = new Creator<QuestionObject>() {
		@Override
		public QuestionObject createFromParcel(Parcel in) {
			return new QuestionObject(in);
		}

		@Override
		public QuestionObject[] newArray(int size) {
			return new QuestionObject[size];
		}
	};

	public int getId() {
		return this.id;
	}

	public int getQuestion() {
		return this.question;
	}

	public String getQuestionString(Context context) {
		return context.getResources().getString(this.question);
	}

	public int getIcon() {
		return this.icon;
	}

	public int getColor() {
		return this.color;
	}

	public String getAnswer(String response) {
		String answer;
		switch (response) {
			case "yes":
				answer = this.answer_yes;
				break;
			case  "no:":
				answer = this.answer_no;
				break;
			case "unsure":
				answer = this.answer_unsure;
				break;
			default:
				answer = "";
		}
		return answer;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(id);
		parcel.writeInt(question);
		parcel.writeInt(icon);
		parcel.writeInt(color);
		parcel.writeString(tag);
		parcel.writeString(answer_yes);
		parcel.writeString(answer_no);
		parcel.writeString(answer_unsure);
	}
}
