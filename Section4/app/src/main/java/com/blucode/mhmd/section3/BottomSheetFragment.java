package com.blucode.mhmd.section3;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blucode.mhmd.section3.Adapter.BottomSheetItemListener;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    private View view;
    private View share, info, remove, report;
    private int pos;
    private BottomSheetItemListener listener;

    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet, container, false);
        share = view.findViewById(R.id.txt_bottom_sheet_share);
        info = view.findViewById(R.id.txt_bottom_sheet_info);
        remove = view.findViewById(R.id.txt_bottom_sheet_remove);
        report = view.findViewById(R.id.txt_bottom_sheet_report);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onShareClicked(pos);
                dismiss();
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onInfoClicked(pos);
                dismiss();
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRemoveClicked(pos);
                dismiss();
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onReportClicked(pos);
                dismiss();
            }
        });
        return view;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setListener(BottomSheetItemListener listener) {
        this.listener = listener;
    }
}
