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
	    private Integer releaseYear;

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
	    
	    // Para las relaciones varios a varios usamos ManytoManny
	    // Ponemos cascade MERGE para que no de error al añadir
	    @ManyToMany(cascade = { CascadeType.MERGE })
	    // Especificamos los datos de la tabla intermedia
	    @JoinTable(
	        name = "film_category", // NOmbre
	        joinColumns = { @JoinColumn(name = "film_id") }, // MI foreign key
	        inverseJoinColumns = { @JoinColumn(name = "category_id") } // Foreign Key de la otra entidad
	    )
	    // Tenemos un set porque los valores son únicos
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

		public int getFilmId() {
			return filmId;
		}

		public void setFilmId(int filmId) {
			this.filmId = filmId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getReleaseYear() {
			return releaseYear;
		}

		public void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}

		public int getLanguageId() {
			return languageId;
		}

		public void setLanguageId(int languageId) {
			this.languageId = languageId;
		}

		public Integer getOriginalLanguageId() {
			return originalLanguageId;
		}

		public void setOriginalLanguageId(Integer originalLanguageId) {
			this.originalLanguageId = originalLanguageId;
		}

		public int getRentalDuration() {
			return rentalDuration;
		}

		public void setRentalDuration(int rentalDuration) {
			this.rentalDuration = rentalDuration;
		}

		public BigDecimal getRentalRate() {
			return rentalRate;
		}

		public void setRentalRate(BigDecimal rentalRate) {
			this.rentalRate = rentalRate;
		}

		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			this.length = length;
		}

		public BigDecimal getReplacementCost() {
			return replacementCost;
		}

		public void setReplacementCost(BigDecimal replacementCost) {
			this.replacementCost = replacementCost;
		}

		public Timestamp getLastUpdate() {
			return lastUpdate;
		}

		public void setLastUpdate(Timestamp lastUpdate) {
			this.lastUpdate = lastUpdate;
		}

		public Set<Category> getCategories() {
			return categories;
		}

		public void setCategories(Set<Category> categories) {
			this.categories = categories;
		}
		
		@Override
		public String toString() {
			return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
					+ releaseYear + ", languageId=" + languageId + ", originalLanguageId=" + originalLanguageId
					+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
					+ ", replacementCost=" + replacementCost + ", lastUpdate=" + lastUpdate+" categories="+categories + "]";
		}
	    
	    

}
