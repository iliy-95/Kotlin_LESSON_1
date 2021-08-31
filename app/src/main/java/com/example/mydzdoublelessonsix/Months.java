package com.example.mydzdoublelessonsix;


import android.os.Parcel;
import android.os.Parcelable;

public abstract class Months implements Parcelable {



   private static String monthsName;
   private static int imageIndex;

    public Months(int imageIndex, String monthsName){
        this.imageIndex = imageIndex;
        this.monthsName = monthsName;
    }
    protected Months(Parcel in) {
        imageIndex = in.readInt();
        monthsName = in.readString();
    }

    public static int getimageIndex() {

        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getImageIndex());
        dest.writeString(getMonthsName());
    }




    @Override
    public int describeContents() {

        return 0;
    }

    public static final Creator<Months> CREATOR = new Creator<Months>() {
        @Override
        public Months createFromParcel(Parcel in) {
            return new Months(in) {
            };
        }

        @Override
        public Months[] newArray(int size) {
            return new Months[size];
        }
    };

    public int getImageIndex() {
        return imageIndex;
    }



    public String getMonthsName() {
        return monthsName;
    }


}
