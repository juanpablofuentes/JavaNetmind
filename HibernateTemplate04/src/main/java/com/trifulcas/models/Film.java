package com.trifulcas.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "film")
public class Film {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "film_id")
	    private int filmId;

	    @Column(name = "title", nullable = false)
	    private String title;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "release_year")
	    private int releaseYear;

	    @Column(name = "language_id", nullable = false)
	    private int languageId;

	    @Column(name = "original_language_id")
	    private Integer originalLanguageId;

	    @Column(name = "rental_duration", nullable = false)
	    private int rentalDuration;

	    @Column(name = "rental_rate", nullable = false)
	    private BigDecimal rentalRate;

	    @Column(name = "length")
	    private Integer length;

	    @Column(name = "replacement_cost", nullable = false)
	    private BigDecimal replacementCost;

	    @Column(name = "last_update", nullable = false)
	    private Timestamp lastUpdate;
	    
	    @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "film_category", 
	        joinColumns = { @JoinColumn(name = "film_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "category_id") }
	    )
	    Set<Category> categories = new HashSet<>();
		public Film() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Film(int filmId, String title, String description, int releaseYear, int languageId,
				Integer originalLanguageId, int rentalDuration, BigDecimal rentalRate, Integer length,
				BigDecimal replacementCost, Timestamp lastUpdate) {
			super();
			this.filmId = filmId;
			this.title = title;
			this.description = description;
			this.releaseYear = releaseYear;
			this.languageId = languageId;
			this.originalLanguageId = originalLanguageId;
			this.rentalDuration = rentalDuration;
			this.rentalRate = rentalRate;
			this.length = length;
			this.replacementCost = replacementCost;
			this.lastUpdate = lastUpdate;
		}

		protected int getFilmId() {
			return filmId;
		}

		protected void setFilmId(int filmId) {
			this.filmId = filmId;
		}

		protected String getTitle() {
			return title;
		}

		protected void setTitle(String title) {
			this.title = title;
		}

		protected String getDescription() {
			return description;
		}

		protected void setDescription(String description) {
			this.description = description;
		}

		protected int getReleaseYear() {
			return releaseYear;
		}

		protected void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}

		protected int getLanguageId() {
			return languageId;
		}

		protected void setLanguageId(int languageId) {
			this.languageId = languageId;
		}

		protected Integer getOriginalLanguageId() {
			return originalLanguageId;
		}

		protected void setOriginalLanguageId(Integer originalLanguageId) {
			this.originalLanguageId = originalLanguageId;
		}

		protected int getRentalDuration() {
			return rentalDuration;
		}

		protected void setRentalDuration(int rentalDuration) {
			this.rentalDuration = rentalDuration;
		}

		protected BigDecimal getRentalRate() {
			return rentalRate;
		}

		protected void setRentalRate(BigDecimal rentalRate) {
			this.rentalRate = rentalRate;
		}

		protected Integer getLength() {
			return length;
		}

		protected void setLength(Integer length) {
			this.length = length;
		}

		protected BigDecimal getReplacementCost() {
			return replacementCost;
		}

		protected void setReplacementCost(BigDecimal replacementCost) {
			this.replacementCost = replacementCost;
		}

		protected Timestamp getLastUpdate() {
			return lastUpdate;
		}

		protected void setLastUpdate(Timestamp lastUpdate) {
			this.lastUpdate = lastUpdate;
		}

		@Override
		public String toString() {
			return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
					+ releaseYear + ", languageId=" + languageId + ", originalLanguageId=" + originalLanguageId
					+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
					+ ", replacementCost=" + replacementCost + ", lastUpdate=" + lastUpdate+" categories="+categories + "]";
		}
	    
	    

}
