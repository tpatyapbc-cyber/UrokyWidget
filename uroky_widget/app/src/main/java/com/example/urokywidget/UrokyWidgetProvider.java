package com.example.urokywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class UrokyWidgetProvider extends AppWidgetProvider {
    private static final String[] URLS = {
        "https://meet.google.com/zih-fqrh-qfq?pli=1",
        "https://meet.google.com/mwe-wjdh-zyg",
        "https://meet.google.com/gbf-ytwm-zkv?authuser=0",
        "https://meet.google.com/jvi-btjp-ysp"
    };
    private static final int[] IDS = {R.id.btnEnglish1, R.id.btnInfo, R.id.btnMusic, R.id.btnOther};

    @Override public void onUpdate(Context context, AppWidgetManager manager, int[] appWidgetIds) {
        for (int widgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
            for (int i = 0; i < IDS.length; i++) {
                Intent intent = new Intent(context, LinkActivity.class).putExtra("url", URLS[i]);
                PendingIntent pi = PendingIntent.getActivity(context, 100+i, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                views.setOnClickPendingIntent(IDS[i], pi);
            }
            manager.updateAppWidget(widgetId, views);
        }
    }
}
