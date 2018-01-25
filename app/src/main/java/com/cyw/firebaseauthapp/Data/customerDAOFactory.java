package com.cyw.firebaseauthapp.Data;

import android.content.Context;

/**
 * Created by vivian on 2018/1/25.
 */

public class customerDAOFactory {
    public static customerDAOinterface getDAOInstance(Context context, DBtype dbType)
{
    switch (dbType)
    {

        case FILE:
            return new customerDAO(context);

        case CLOUD:
            return new customerCloudDAO(context);
    }
    return null;
}

}
