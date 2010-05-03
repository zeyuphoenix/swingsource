package org.yccheok.blobsallad;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Blob {
	List<Stick> sticks = new ArrayList<Stick>();
	List<PointMass> pointMasses = new ArrayList<PointMass>();
	List<Joint> joints = new ArrayList<Joint>();
	private PointMass middlePointMass;
	private double radius;
	private double drawFaceStyle;
	private double drawEyeStyle;
	private boolean selected;

	public Blob(double x, double y, double radius, int numPointMasses) {
		this.radius = radius;
		this.drawFaceStyle = 1;
		this.drawEyeStyle = 1;
		this.selected = false;

		double low = 0.95, high = 1.05;
		double t;
		int i, p;

		for (i = 0, t = 0.0; i < numPointMasses; i++) {
			pointMasses.add(i, new PointMass(Math.cos(t) * radius + x, Math
					.sin(t)
					* radius + y, 1.0));
			t += 2.0 * Math.PI / numPointMasses;
		}

		this.middlePointMass = new PointMass(x, y, 1.0);

		this.pointMasses.get(0).setMass(4.0);
		this.pointMasses.get(1).setMass(4.0);

		for (i = 0; i < numPointMasses; i++) {
			this.sticks.add(i, new Stick(this.pointMasses.get(i),
					this.pointMasses.get(clampIndex(i + 1, numPointMasses))));
		}

		for (i = 0, p = 0; i < numPointMasses; i++) {
			this.joints.add(p++, new Joint(this.pointMasses.get(i),
					this.pointMasses.get(clampIndex(i + numPointMasses / 2 + 1,
							numPointMasses)), low, high));
			this.joints.add(p++, new Joint(this.pointMasses.get(i),
					this.middlePointMass, high * 0.9, low * 1.1)); // 0.8, 1.2
			// works
		}
	}

	private int clampIndex(int index, int maxIndex) {
		index += maxIndex;
		return index % maxIndex;
	}

	public PointMass getMiddlePointMass() {
		return this.middlePointMass;
	}

	public double getRadius() {
		return this.radius;
	}

	public void addBlob(Blob blob) {
		int index = this.joints.size();
		double dist;

		this.joints.add(index, new Joint(this.middlePointMass, blob
				.getMiddlePointMass(), 0.0, 0.0));
		dist = this.radius + blob.getRadius();
		this.joints.get(index).setDist(dist * 0.95, 0.0);
	}

	public double getXPos() {
		return this.middlePointMass.getXPos();
	}

	public double getYPos() {
		return this.middlePointMass.getYPos();
	}

	public void scale(double scaleFactor) {
		int i;

		for (i = 0; i < this.joints.size(); i++) {
			this.joints.get(i).scale(scaleFactor);
		}
		for (i = 0; i < this.sticks.size(); i++) {
			this.sticks.get(i).scale(scaleFactor);
		}
		this.radius *= scaleFactor;
	}

	public void move(double dt) {
		int i;

		for (i = 0; i < this.pointMasses.size(); i++) {
			this.pointMasses.get(i).move(dt);
		}
		this.middlePointMass.move(dt);
	}

	public void sc(Environment env) {
		int i, j;

		for (j = 0; j < 4; j++) {
			for (i = 0; i < this.pointMasses.size(); i++) {
				if (env.collision(this.pointMasses.get(i).getPos(),
						this.pointMasses.get(i).getPrevPos()) == true) {
					this.pointMasses.get(i).setFriction(0.75);
				} else {
					this.pointMasses.get(i).setFriction(0.01);
				}
			}
			for (i = 0; i < this.sticks.size(); i++) {
				this.sticks.get(i).sc(env);
			}

			for (i = 0; i < this.joints.size(); i++) {
				this.joints.get(i).sc();
			}
		}
	}

	public void setForce(Vector force) {
		int i;

		for (i = 0; i < this.pointMasses.size(); i++) {
			this.pointMasses.get(i).setForce(force);
		}
		this.middlePointMass.setForce(force);
	}

	public void addForce(Vector force) {
		int i;

		for (i = 0; i < this.pointMasses.size(); i++) {
			this.pointMasses.get(i).addForce(force);
		}
		this.middlePointMass.addForce(force);
		this.pointMasses.get(0).addForce(force);
		this.pointMasses.get(0).addForce(force);
		this.pointMasses.get(0).addForce(force);
		this.pointMasses.get(0).addForce(force);
	}

	public void moveTo(double x, double y) {
		int i;
		Vector blobPos;

		blobPos = this.middlePointMass.getPos();
		x -= blobPos.getX();
		y -= blobPos.getY();

		for (i = 0; i < this.pointMasses.size(); i++) {
			blobPos = this.pointMasses.get(i).getPos();
			blobPos.addX(x);
			blobPos.addY(y);
		}
		blobPos = this.middlePointMass.getPos();
		blobPos.addX(x);
		blobPos.addY(y);
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void drawEars(Graphics graphics, double scaleFactor) {
		// ctx.strokeStyle = "#000000";
		// ctx.fillStyle = "#FFFFFF";
		// ctx.lineWidth = 2;
		//
		// ctx.beginPath();
		// ctx.moveTo((-0.55 * this.radius) * scaleFactor, (-0.35 * this.radius)
		// * scaleFactor);
		// ctx.lineTo((-0.52 * this.radius) * scaleFactor, (-0.55 * this.radius)
		// * scaleFactor);
		// ctx.lineTo((-0.45 * this.radius) * scaleFactor, (-0.40 * this.radius)
		// * scaleFactor);
		// ctx.fill();
		// ctx.stroke();
		//
		// ctx.beginPath();
		// ctx.moveTo((0.55 * this.radius) * scaleFactor, (-0.35 * this.radius)
		// * scaleFactor);
		// ctx.lineTo((0.52 * this.radius) * scaleFactor, (-0.55 * this.radius)
		// * scaleFactor);
		// ctx.lineTo((0.45 * this.radius) * scaleFactor, (-0.40 * this.radius)
		// * scaleFactor);
		// ctx.fill();
		// ctx.stroke();
	}

	public void drawHappyEyes1(Graphics graphics, double scaleFactor) {
		// ctx.lineWidth = 1;
		// ctx.fillStyle = "#FFFFFF";
		// ctx.beginPath();
		// ctx.arc((-0.15 * this.radius) * scaleFactor,
		// (-0.20 * this.radius) * scaleFactor,
		// this.radius * 0.12 * scaleFactor, 0, 2.0 * Math.PI, false);
		// ctx.fill();
		// ctx.stroke();
		//
		// ctx.beginPath();
		// ctx.arc(( 0.15 * this.radius) * scaleFactor,
		// (-0.20 * this.radius) * scaleFactor,
		// this.radius * 0.12 * scaleFactor, 0, 2.0 * Math.PI, false);
		// ctx.fill();
		// ctx.stroke();
		//
		// ctx.fillStyle = "#000000";
		// ctx.beginPath();
		// ctx.arc((-0.15 * this.radius) * scaleFactor,
		// (-0.17 * this.radius) * scaleFactor,
		// this.radius * 0.06 * scaleFactor, 0, 2.0 * Math.PI, false);
		// ctx.fill();
		//
		// ctx.beginPath();
		// ctx.arc(( 0.15 * this.radius) * scaleFactor,
		// (-0.17 * this.radius) * scaleFactor,
		// this.radius * 0.06 * scaleFactor, 0, 2.0 * Math.PI, false);
		// ctx.fill();

		BasicStroke stroke = new BasicStroke(1.0f);
		Graphics2D g2d = (Graphics2D) graphics;

		g2d.setStroke(stroke);
		Arc2D.Double arc = new Arc2D.Double();
		arc.setArcByCenter((-0.15 * this.radius) * scaleFactor,
				(-0.20 * this.radius) * scaleFactor, this.radius * 0.12
						* scaleFactor, 0, -360.0, Arc2D.CHORD);
		g2d.setColor(Color.WHITE);
		g2d.fill(arc);
		g2d.setColor(Color.BLACK);
		g2d.draw(arc);

		arc.setArcByCenter((0.15 * this.radius) * scaleFactor,
				(-0.20 * this.radius) * scaleFactor, this.radius * 0.12
						* scaleFactor, 0, -360.0, Arc2D.CHORD);
		g2d.setColor(Color.WHITE);
		g2d.fill(arc);
		g2d.setColor(Color.BLACK);
		g2d.draw(arc);

		g2d.setColor(Color.BLACK);
		arc.setArcByCenter((-0.15 * this.radius) * scaleFactor,
				(-0.17 * this.radius) * scaleFactor, this.radius * 0.06
						* scaleFactor, 0, -360.0, Arc2D.CHORD);
		g2d.fill(arc);

		arc.setArcByCenter((0.15 * this.radius) * scaleFactor,
				(-0.17 * this.radius) * scaleFactor, this.radius * 0.06
						* scaleFactor, 0, -360.0, Arc2D.CHORD);
		g2d.fill(arc);
	}

	public void drawHappyEyes2(Graphics graphics, double scaleFactor) {
		// ctx.lineWidth = 1;
		// ctx.fillStyle = "#FFFFFF";
		// ctx.beginPath();
		// ctx.arc((-0.15 * this.radius) * scaleFactor,
		// (-0.20 * this.radius) * scaleFactor,
		// this.radius * 0.12 * scaleFactor, 0, 2.0 * Math.PI, false);
		// ctx.stroke();
		//
		// ctx.beginPath();
		// ctx.arc(( 0.15 * this.radius) * scaleFactor,
		// (-0.20 * this.radius) * scaleFactor,
		// this.radius * 0.12 * scaleFactor, 0, 2.0 * Math.PI, false);
		// ctx.stroke();
		//
		// ctx.lineWidth = 1;
		// ctx.beginPath();
		// ctx.moveTo((-0.25 * this.radius) * scaleFactor,
		// (-0.20 * this.radius) * scaleFactor);
		// ctx.lineTo((-0.05 * this.radius) * scaleFactor,
		// (-0.20 * this.radius) * scaleFactor);
		// ctx.stroke();
		//
		// ctx.beginPath();
		// ctx.moveTo(( 0.25 * this.radius) * scaleFactor,
		// (-0.20 * this.radius) * scaleFactor);
		// ctx.lineTo(( 0.05 * this.radius) * scaleFactor,
		// (-0.20 * this.radius) * scaleFactor);
		// ctx.stroke();

		BasicStroke stroke = new BasicStroke(1.0f);
		Graphics2D g2d = (Graphics2D) graphics;

		g2d.setColor(Color.BLACK); // ???
		g2d.setStroke(stroke);
		Arc2D.Double arc = new Arc2D.Double();
		arc.setArcByCenter((-0.15 * this.radius) * scaleFactor,
				(-0.20 * this.radius) * scaleFactor, this.radius * 0.12
						* scaleFactor, 0.0, -360.0, Arc2D.OPEN);
		g2d.draw(arc);

		arc.setArcByCenter((0.15 * this.radius) * scaleFactor,
				(-0.20 * this.radius) * scaleFactor, this.radius * 0.12
						* scaleFactor, 0.0, -360.0, Arc2D.OPEN);
		g2d.draw(arc);

		GeneralPath generalPath = new GeneralPath();
		generalPath.moveTo((-0.25 * this.radius) * scaleFactor,
				(-0.20 * this.radius) * scaleFactor);
		generalPath.lineTo((-0.05 * this.radius) * scaleFactor,
				(-0.20 * this.radius) * scaleFactor);
		g2d.draw(generalPath);

		generalPath.reset();
		generalPath.moveTo((0.25 * this.radius) * scaleFactor,
				(-0.20 * this.radius) * scaleFactor);
		generalPath.lineTo((0.05 * this.radius) * scaleFactor,
				(-0.20 * this.radius) * scaleFactor);
		g2d.draw(generalPath);
	}

	public void drawHappyFace1(Graphics graphics, double scaleFactor) {
		// ctx.lineWidth = 2;
		// ctx.strokeStyle = "#000000";
		// ctx.fillStyle = "#000000";
		// ctx.beginPath();
		// ctx.arc(0.0, 0.0,
		// this.radius * 0.25 * scaleFactor, 0, Math.PI, false);
		// ctx.stroke();

		BasicStroke stroke = new BasicStroke(2.0f);
		Graphics2D g2d = (Graphics2D) graphics;

		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		Arc2D.Double arc = new Arc2D.Double();
		arc.setArcByCenter(0.0, 0.0, this.radius * 0.25 * scaleFactor, 0.0,
				-180.0, Arc2D.OPEN);
		g2d.draw(arc);
	}

	public void drawHappyFace2(Graphics graphics, double scaleFactor) {
		// ctx.lineWidth = 2;
		// ctx.strokeStyle = "#000000";
		// ctx.fillStyle = "#000000";
		// ctx.beginPath();
		// ctx.arc(0.0, 0.0,
		// this.radius * 0.25 * scaleFactor, 0, Math.PI, false);
		// ctx.fill();

		BasicStroke stroke = new BasicStroke(2.0f);
		Graphics2D g2d = (Graphics2D) graphics;

		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		Arc2D.Double arc = new Arc2D.Double();
		arc.setArcByCenter(0.0, 0.0, this.radius * 0.25 * scaleFactor, 0.0,
				-180.0, Arc2D.CHORD);
		g2d.fill(arc);
	}

	public void drawOohFace(Graphics graphics, double scaleFactor) {
		// ctx.lineWidth = 2;
		// ctx.strokeStyle = "#000000";
		// ctx.fillStyle = "#000000";
		// ctx.beginPath();
		// ctx.arc(0.0, (0.1 * this.radius) * scaleFactor,
		// this.radius * 0.25 * scaleFactor, 0, Math.PI, false);
		// ctx.fill();
		//
		// ctx.beginPath();
		//
		// ctx.moveTo((-0.25 * this.radius) * scaleFactor, (-0.3 * this.radius)
		// * scaleFactor);
		// ctx.lineTo((-0.05 * this.radius) * scaleFactor, (-0.2 * this.radius)
		// * scaleFactor);
		// ctx.lineTo((-0.25 * this.radius) * scaleFactor, (-0.1 * this.radius)
		// * scaleFactor);
		//
		// ctx.moveTo((0.25 * this.radius) * scaleFactor, (-0.3 * this.radius) *
		// scaleFactor);
		// ctx.lineTo((0.05 * this.radius) * scaleFactor, (-0.2 * this.radius) *
		// scaleFactor);
		// ctx.lineTo((0.25 * this.radius) * scaleFactor, (-0.1 * this.radius) *
		// scaleFactor);
		//
		// ctx.stroke();
		BasicStroke stroke = new BasicStroke(2.0f);
		Graphics2D g2d = (Graphics2D) graphics;

		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);

		Arc2D.Double arc = new Arc2D.Double();
		arc.setArcByCenter(0.0, (0.1 * this.radius) * scaleFactor, this.radius
				* 0.25 * scaleFactor, 0.0, -180.0, Arc2D.CHORD);
		g2d.fill(arc);

		GeneralPath generalPath = new GeneralPath();
		generalPath.moveTo((-0.25 * this.radius) * scaleFactor,
				(-0.3 * this.radius) * scaleFactor);
		generalPath.lineTo((-0.05 * this.radius) * scaleFactor,
				(-0.2 * this.radius) * scaleFactor);
		generalPath.lineTo((-0.25 * this.radius) * scaleFactor,
				(-0.1 * this.radius) * scaleFactor);

		generalPath.moveTo((0.25 * this.radius) * scaleFactor,
				(-0.3 * this.radius) * scaleFactor);
		generalPath.lineTo((0.05 * this.radius) * scaleFactor,
				(-0.2 * this.radius) * scaleFactor);
		generalPath.lineTo((0.25 * this.radius) * scaleFactor,
				(-0.1 * this.radius) * scaleFactor);

		g2d.draw(generalPath);
	}

	public void drawFace(Graphics graphics, double scaleFactor) {
		if (this.drawFaceStyle == 1 && Math.random() < 0.05) {
			this.drawFaceStyle = 2;
		} else if (this.drawFaceStyle == 2 && Math.random() < 0.1) {
			this.drawFaceStyle = 1;
		}

		if (this.drawEyeStyle == 1 && Math.random() < 0.025) {
			this.drawEyeStyle = 2;
		} else if (this.drawEyeStyle == 2 && Math.random() < 0.3) {
			this.drawEyeStyle = 1;
		}

		if (this.middlePointMass.getVelocity() > 0.004) {
			this.drawOohFace(graphics, scaleFactor);
		} else {
			if (this.drawFaceStyle == 1) {
				this.drawHappyFace1(graphics, scaleFactor);
			} else {
				this.drawHappyFace2(graphics, scaleFactor);
			}

			if (this.drawEyeStyle == 1) {
				this.drawHappyEyes1(graphics, scaleFactor);
			} else {
				this.drawHappyEyes2(graphics, scaleFactor);
			}
		}
	}

	public PointMass getPointMass(int index) {
		index += this.pointMasses.size();
		index = index % this.pointMasses.size();
		return this.pointMasses.get(index);
	}

	public void drawBody(Graphics graphics, double scaleFactor) {
		// var i;
		//
		// ctx.strokeStyle = "#000000";
		// if(this.selected == true)
		// {
		// ctx.fillStyle = "#FFCCCC";
		// }
		// else
		// {
		// ctx.fillStyle = "#FFFFFF";
		// }
		// ctx.lineWidth = 5;
		// ctx.beginPath();
		// ctx.moveTo(this.pointMasses[0].getXPos() * scaleFactor,
		// this.pointMasses[0].getYPos() * scaleFactor);
		//
		// for(i = 0; i < this.pointMasses.length; i++)
		// {
		// var px, py, nx, ny, tx, ty, cx, cy;
		// var prevPointMass, currentPointMass, nextPointMass,
		// nextNextPointMass;
		//
		// prevPointMass = this.getPointMass(i - 1);
		// currentPointMass = this.pointMasses[i];
		// nextPointMass = this.getPointMass(i + 1);
		// nextNextPointMass = this.getPointMass(i + 2);
		//
		// tx = nextPointMass.getXPos();
		// ty = nextPointMass.getYPos();
		//
		// cx = currentPointMass.getXPos();
		// cy = currentPointMass.getYPos();
		//
		// px = cx * 0.5 + tx * 0.5;
		// py = cy * 0.5 + ty * 0.5;
		//
		// nx = cx - prevPointMass.getXPos() + tx - nextNextPointMass.getXPos();
		// ny = cy - prevPointMass.getYPos() + ty - nextNextPointMass.getYPos();
		//
		// px += nx * 0.16;
		// py += ny * 0.16;
		//
		// px = px * scaleFactor;
		// py = py * scaleFactor;
		//
		// tx = tx * scaleFactor;
		// ty = ty * scaleFactor;
		//
		// ctx.bezierCurveTo(px, py, tx, ty, tx, ty);
		// }
		//
		// ctx.closePath();
		// ctx.stroke();
		// ctx.fill();

		GeneralPath generalPath = new GeneralPath();
		generalPath.moveTo(this.pointMasses.get(0).getXPos() * scaleFactor,
				this.pointMasses.get(0).getYPos() * scaleFactor);

		for (int i = 0; i < pointMasses.size(); i++) {
			double px, py, nx, ny, tx, ty, cx, cy;
			PointMass prevPointMass, currentPointMass, nextPointMass, nextNextPointMass;

			prevPointMass = this.getPointMass(i - 1);
			currentPointMass = this.pointMasses.get(i);
			nextPointMass = this.getPointMass(i + 1);
			nextNextPointMass = this.getPointMass(i + 2);

			tx = nextPointMass.getXPos();
			ty = nextPointMass.getYPos();
			cx = currentPointMass.getXPos();
			cy = currentPointMass.getYPos();

			px = cx * 0.5 + tx * 0.5;
			py = cy * 0.5 + ty * 0.5;

			nx = cx - prevPointMass.getXPos() + tx
					- nextNextPointMass.getXPos();
			ny = cy - prevPointMass.getYPos() + ty
					- nextNextPointMass.getYPos();

			px += nx * 0.16;
			py += ny * 0.16;

			px = px * scaleFactor;
			py = py * scaleFactor;

			tx = tx * scaleFactor;
			ty = ty * scaleFactor;

			generalPath.curveTo(px, py, tx, ty, tx, ty);
		}

		Graphics2D g2d = (Graphics2D) graphics;
		generalPath.closePath();
		BasicStroke stroke = new BasicStroke(5.0f);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		g2d.draw(generalPath);
		Color color = null;
		if (this.selected == true) {
			color = new Color(255, 204, 204);
		} else {
			color = Color.WHITE;
		}
		g2d.setColor(color);
		g2d.fill(generalPath);
	}

	public void drawSimpleBody(Graphics graphics, double scaleFactor) {
		for (int i = 0; i < this.sticks.size(); i++) {
			this.sticks.get(i).draw(graphics, scaleFactor);
		}
	}

	public void draw(Graphics graphics, double scaleFactor) {
		Graphics2D g2 = (Graphics2D) graphics;

		this.drawBody(g2, scaleFactor);
		graphics.setColor(Color.WHITE);

		final AffineTransform savedTransform = g2.getTransform();
		g2.translate(this.middlePointMass.getXPos() * scaleFactor,
				(this.middlePointMass.getYPos() - 0.35 * this.radius)
						* scaleFactor);

		Vector up = new Vector(0.0, -1.0);
		Vector ori = new Vector(0.0, 0.0);
		ori.set(this.pointMasses.get(0).getPos());
		ori.sub(this.middlePointMass.getPos());
		double ang = Math.acos(ori.dotProd(up) / ori.length());
		if (ori.getX() < 0.0) {
			g2.rotate(-ang);
		} else {
			g2.rotate(ang);
		}

		this.drawFace(g2, scaleFactor);

		g2.setTransform(savedTransform);
	}
}
