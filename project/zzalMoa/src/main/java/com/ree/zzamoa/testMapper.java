package com.ree.zzamoa;

import java.util.List;

public interface testMapper {
	public abstract int member_write(Member mb);
	public abstract Member getMemberById(Member mb);
	public abstract int updateMember(Member mb);
	public abstract int memberDel(Member mb);
	public abstract int photolist_write(PhotoList pl);
	public abstract List<PhotoList> getPhotolist(PhotoList pl);
	public abstract List<PhotoList> getPhotolistPage(PhotoListNo pln);
	public abstract List<PhotoList> searchPhotolist(PhotoList pl);
	public abstract PhotoList detailPhotolist(PhotoList pl);
	public abstract int updatePhotoTag(PhotoList pl);
	public abstract int updateThumbnail(PhotoList pl);
	public abstract int PhotoDel(PhotoList pl);
}
