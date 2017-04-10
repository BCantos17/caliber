package com.revature.caliber.training.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CALIBER_TIER")
public class Tier {

	@Id
	@Column(name = "TIER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIER_ID_SEQUENCE")
	@SequenceGenerator(name = "TIER_ID_SEQUENCE", sequenceName = "TIER_ID_SEQUENCE")
	@NotNull
	private short tierId;

	@Column(name = "TIER", nullable = false)
	@NotNull
	private String tier;

	@Column(name = "RANKING", nullable = false)
	@NotNull
	private short ranking;

	public Tier() {
		super();
	}

	public Tier(String tier, short ranking) {
		super();
		this.tier = tier;
		this.ranking = ranking;
	}

	public Tier(short tierId, String tier, short ranking) {
		super();
		this.tierId = tierId;
		this.tier = tier;
		this.ranking = ranking;
	}

	public short getTierId() {
		return tierId;
	}

	public void setTierId(short tierId) {
		this.tierId = tierId;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public short getRanking() {
		return ranking;
	}

	public void setRanking(short ranking) {
		this.ranking = ranking;
	}

}
