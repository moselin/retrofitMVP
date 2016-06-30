package com.moselin.demo.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @Description
 * @Author MoseLin
 * @Date 2016/6/12.
 */
public class WechatEntity implements Parcelable
{
    public String reason;//	string	返回说明
    public WechatResult result;
    public int error_code;//	int	返回码
    public static class WechatResult implements Parcelable
    {
        public ArrayList<WechatList> list;
        public int totalPage;
        public int ps;
        public int pno;

        @Override
        public int describeContents()
        {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags)
        {
            dest.writeList(this.list);
            dest.writeInt(this.totalPage);
            dest.writeInt(this.ps);
            dest.writeInt(this.pno);
        }

        public WechatResult()
        {
        }

        protected WechatResult(Parcel in)
        {
            this.list = new ArrayList<WechatList>();
            in.readList(this.list, WechatList.class.getClassLoader());
            this.totalPage = in.readInt();
            this.ps = in.readInt();
            this.pno = in.readInt();
        }

        public static final Creator<WechatResult> CREATOR = new Creator<WechatResult>()
        {
            @Override
            public WechatResult createFromParcel(Parcel source)
            {
                return new WechatResult(source);
            }

            @Override
            public WechatResult[] newArray(int size)
            {
                return new WechatResult[size];
            }
        };
    }

    public static class WechatList implements Parcelable
    {
        public String id;
        public String title;
        public String source;
        public String firstImg;
        public String mark;
        public String url;

        @Override
        public int describeContents()
        {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags)
        {
            dest.writeString(this.id);
            dest.writeString(this.title);
            dest.writeString(this.source);
            dest.writeString(this.firstImg);
            dest.writeString(this.mark);
            dest.writeString(this.url);
        }

        public WechatList()
        {
        }

        protected WechatList(Parcel in)
        {
            this.id = in.readString();
            this.title = in.readString();
            this.source = in.readString();
            this.firstImg = in.readString();
            this.mark = in.readString();
            this.url = in.readString();
        }

        public static final Creator<WechatList> CREATOR = new Creator<WechatList>()
        {
            @Override
            public WechatList createFromParcel(Parcel source)
            {
                return new WechatList(source);
            }

            @Override
            public WechatList[] newArray(int size)
            {
                return new WechatList[size];
            }
        };
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.reason);
        dest.writeParcelable(this.result, flags);
        dest.writeInt(this.error_code);
    }

    public WechatEntity()
    {
    }

    protected WechatEntity(Parcel in)
    {
        this.reason = in.readString();
        this.result = in.readParcelable(WechatResult.class.getClassLoader());
        this.error_code = in.readInt();
    }

    public static final Creator<WechatEntity> CREATOR = new Creator<WechatEntity>()
    {
        @Override
        public WechatEntity createFromParcel(Parcel source)
        {
            return new WechatEntity(source);
        }

        @Override
        public WechatEntity[] newArray(int size)
        {
            return new WechatEntity[size];
        }
    };
}
