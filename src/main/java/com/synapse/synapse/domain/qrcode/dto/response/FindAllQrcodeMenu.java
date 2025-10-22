package com.synapse.synapse.domain.qrcode.dto.response;

import java.util.List;

import com.synapse.synapse.domain.admin.kiosk_management.option.entity.OptionCategory;
import com.synapse.synapse.domain.admin.qrcode_management.entity.QrcodeMenu;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class FindAllQrcodeMenu {

	private Long menuId;
	private String menuName;
	private String menuDescription;
	private String imgUrl;
	private List<OptionCategory> optionCategories;

	public static FindAllQrcodeMenu fromEntity(QrcodeMenu qrcodeMenu) {
		return FindAllQrcodeMenu.builder()
			.menuId(qrcodeMenu.getId())
			.menuName(qrcodeMenu.getMenuName())
			.menuDescription(qrcodeMenu.getMenuDescription())
			.imgUrl(qrcodeMenu.getImgUrl())
			.optionCategories(qrcodeMenu.getOptionCategories()) // 엔티티 그대로 넣기
			.build();
	}
}
