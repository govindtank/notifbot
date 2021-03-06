package com.yhsif.notifbot

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View

class PkgAdapter(
    list: MutableList<PkgData>,
    listener: View.OnClickListener
) : RecyclerView.Adapter<PkgViewHolder>() {
  var list = list
  val listener = listener

  override fun onCreateViewHolder(parent: ViewGroup, vt: Int): PkgViewHolder {
    val v =
      LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.pkg_item, parent, false)
    v.setOnClickListener(listener)
    return PkgViewHolder(v)
  }

  override fun onBindViewHolder(vh: PkgViewHolder, i: Int) {
    vh.setIcon(list.get(i).icon)
    vh.setName(list.get(i).name)
    vh.setBackground(i)
  }

  override fun getItemCount(): Int = list.size

  override fun onAttachedToRecyclerView(rv: RecyclerView) {
    super.onAttachedToRecyclerView(rv)
  }

  fun remove(i: Int) {
    list.removeAt(i)
    notifyDataSetChanged()
  }
}
