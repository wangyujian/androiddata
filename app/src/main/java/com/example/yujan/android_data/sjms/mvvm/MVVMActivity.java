package com.example.yujan.android_data.sjms.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.databinding.ActivityMvvmBinding;

/**
 * 作用：
 * Model_View_ViewModel模型演示
 * 详情：
 * Model ：负责数据实现和逻辑处理，类似MVP。
 * View ： 对应于Activity和XML，负责View的绘制以及与用户交互，类似MVP。
 * ViewModel ： 创建关联，将model和view绑定起来,如此之后，我们model的更改，通过viewmodel反馈给view,从而自动刷新界面。
 *
 * MVP中我们说过随着业务逻辑的增加，UI的改变多的情况下，会有非常多的跟UI相关的case，这样就会造成View的接口会很庞大。
 * 而MVVM就解决了这个问题，通过双向绑定的机制，实现数据和UI内容，只要想改其中一方，另一方都能够及时更新的一种设计理念，
 * 这样就省去了很多在View层中写很多case的情况，只需要改变数据就行。
 * 总结：
 * View和ViewModel通过Binding进行关联，他们之前的关联处理通过DataBinding完成。
 * MVVM中跟MVP中一样，将三层划分的很清楚，Activity和xml layout充当View，ViewModel处理业务逻辑以及获取数据，弱化Model。
 * 看起来MVVM很好的解决了MVC和MVP的不足，但是由于数据和视图的双向绑定，导致出现问题时不太好定位来源，有可能数据问题导致，
 * 也有可能业务逻辑中对视图属性的修改导致。
 * 如果项目中打算用MVVM的话可以考虑使用官方的架构组件ViewModel、LiveData、DataBinding去实现MVVM
 */
public class MVVMActivity extends AppCompatActivity {
    private ActivityMvvmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        MVVMViewModel mvvmViewModel = new MVVMViewModel(getApplication(),binding);
        binding.setViewModel(mvvmViewModel);
    }
}
