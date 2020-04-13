package com.example.yujan.android_data.jsonparse;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：生成json
 * {
 * "name": "androiddata",
 * "url": "https://github.com/wangyujian",
 * "address": {
 * "age": 26,
 * "country": "中国"
 * },
 * "links": [
 * {
 * "name": "GitHub",
 * "url": "https://github.com/wangyujian"
 * },
 * {
 * "name": "CSDN",
 * "url": "https://blog.csdn.net/Yujan_2015"
 * }
 * ]
 * }
 * 详情：根据生成的json，利用多种方式解析
 */
public class JsonParseActivity extends BaseActivity implements View.OnClickListener {
    private String jsonStr;
    private TextView tv_result_json;
    private TextView tv_parse_api_result;
    private TextView tv_parse_gson_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parse);
        tv_result_json = findViewById(R.id.tv_result_json);
        tv_parse_api_result = findViewById(R.id.tv_parse_api_result);
        tv_parse_gson_result = findViewById(R.id.tv_parse_gson_result);
        findViewById(R.id.btn_get_json).setOnClickListener(this);
        findViewById(R.id.btn_parse_api).setOnClickListener(this);
        findViewById(R.id.btn_parse_gson).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_json:
                //getJsonString();
                getJsonStringByGson();
                break;
            case R.id.btn_parse_api:
                parseJsonByAndroidApi();
                break;
            case R.id.btn_parse_gson:
                if (isJsonStrEmpty()) {
                    jsonStr = "dasdfasfasdf";
                    UserInfoJsonResultBean resultBean = parseJsonByGson(UserInfoJsonResultBean.class);
                    tv_parse_gson_result.setText("结果：\n姓名：" + resultBean.getName() + "\n链接：" + resultBean.getUrl());
                }
                break;
        }
    }

    /**
     * 生成json字符串（原生）
     */
    private void getJsonString() {
        try {
            JSONObject object = new JSONObject();
            object.put("name", "androiddata");
            object.put("url", "https://github.com/wangyujian");

            JSONObject addressObject = new JSONObject();
            addressObject.put("age", 26);
            addressObject.put("country", "中国");
            object.put("address", addressObject);

            JSONArray linksArray = new JSONArray();

            JSONObject linkObject1 = new JSONObject();
            linkObject1.put("name", "GitHub");
            linkObject1.put("url", "https://github.com/wangyujian");
            linksArray.put(linkObject1);

            JSONObject linkObject2 = new JSONObject();
            linkObject2.put("name", "CSDN");
            linkObject2.put("url", "https://blog.csdn.net/Yujan_2015");
            linksArray.put(linkObject2);

            object.put("links", linksArray);
            //处理json字符串带反斜杠
            jsonStr = object.toString().replaceAll("\\\\", "");

            tv_result_json.setText("json字符串：" + jsonStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成json字符串（Gson）
     */
    private void getJsonStringByGson() {
        UserInfoJsonBean object = new UserInfoJsonBean();
        object.setName("androiddata");
        object.setUrl("https://github.com/wangyujian");

        UserInfoJsonBean.AddressBean addressObject = new UserInfoJsonBean.AddressBean();
        addressObject.setAge(26);
        addressObject.setCountry("中国");
        object.setAddress(addressObject);

        ArrayList<UserInfoJsonBean.LinksBean> linksBeans = new ArrayList<>();
        UserInfoJsonBean.LinksBean linkObject1 = new UserInfoJsonBean.LinksBean();
        linkObject1.setName("GitHub");
        linkObject1.setUrl("https://github.com/wangyujian");
        linksBeans.add(linkObject1);
        UserInfoJsonBean.LinksBean linkObject2 = new UserInfoJsonBean.LinksBean();
        linkObject2.setName("CSDN");
        linkObject2.setUrl("https://blog.csdn.net/Yujan_2015");
        linksBeans.add(linkObject2);

        object.setLinks(linksBeans);

        Gson gson = new Gson();
        jsonStr = gson.toJson(object);
        //该方式无需处理json字符串带反斜杠
        tv_result_json.setText("json字符串：" + jsonStr);
    }

    /**
     * 利用android原生API解析json
     */
    private void parseJsonByAndroidApi() {
        if (isJsonStrEmpty()) {
            try {
                JSONObject object = new JSONObject(jsonStr);
                UserInfoJsonResultBean resultBean = new UserInfoJsonResultBean();
                //resultBean.setName(object.getString("name1"));//key不存在，报异常 org.json.JSONException: No value for name1
                //resultBean.setName(object.optString("name1"));//opt请求 key不存在，默认返回空字符串，不报异常
                //resultBean.setName(object.optString("name1", "yujan"));//opt请求 key不存在，返回默认值yujan

//                resultBean.setName(object.optString("name1"));
                resultBean.setName(object.getString("name"));
                resultBean.setUrl(object.getString("url"));

                JSONObject object1 = object.getJSONObject("address");
                UserInfoJsonResultBean.AddressBean addressBean = new UserInfoJsonResultBean.AddressBean();
                addressBean.setAge(object1.getInt("age"));
                addressBean.setCountry(object1.getString("country"));
                resultBean.setAddress(addressBean);

                ArrayList<UserInfoJsonResultBean.LinksBean> linksBeans = new ArrayList<>();
                JSONArray array = object.getJSONArray("links");
                int length = array.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    UserInfoJsonResultBean.LinksBean bean = new UserInfoJsonResultBean.LinksBean();
                    bean.setName(jsonObject.getString("name"));
                    bean.setUrl(jsonObject.getString("url"));
                    linksBeans.add(bean);
                }
                resultBean.setLinks(linksBeans);
                tv_parse_api_result.setText("结果：\n姓名：" + resultBean.getName() + "\n链接：" + resultBean.getUrl());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 利用Gson解析json
     */
    private <T> T parseJsonByGson(Class<T> t) {
        Gson gson = new Gson();
        try {
            return gson.fromJson(jsonStr, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json字符串是否为空
     *
     * @return true：有值 false：无值
     */

    private boolean isJsonStrEmpty() {
        if (TextUtils.isEmpty(jsonStr)) {
            Toast.makeText(JsonParseActivity.this, "请先生成json字符串！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
