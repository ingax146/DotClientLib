package se.inax.dot.constants;

import se.inax.dot.propertymodel.DotEscapedString;

public enum NodeOptions {
	/**
	 * Hyperlinks incorporated into device-dependent output. At present, used 
	 * in ps2, cmap, i*map and svg formats. For all these formats, URLs can be 
	 * attached to nodes, edges and clusters. URL attributes can also be 
	 * attached to the root graph in ps2, cmap and i*map formats. This serves 
	 * as the base URL for relative URLs in the former, and as the default 
	 * image map file in the latter.
	 * 
	 * For svg, cmapx and imap output, the active area for a node is its visible 
	 * image. For example, an unfilled node with no drawn boundary will only be 
	 * active on its label. For other output, the active area is its bounding box.
	 * The active area for a cluster is its bounding box. For edges, the active 
	 * areas are small circles where the edge contacts its head and tail nodes. 
	 * In addition, for svg, cmapx and imap, the active area includes a thin 
	 * polygon approximating the edge. The circles may overlap the related node, 
	 * and the edge URL dominates. If the edge has a label, this will also be 
	 * active. Finally, if the edge has a head or tail label, this will also 
	 * be active.
	 * 
	 * Note that, for edges, the attributes headURL, tailURL, labelURL and edgeURL 
	 * allow control of various parts of an edge. Also note that, if active areas 
	 * of two edges overlap, it is unspecified which area dominates.
	 */
	URL(String.class),			//Postscript, map only.
	/**
	 * Indicates the preferred area for a node or empty cluster when laid out 
	 * by patchwork.
	 */
	area(Double.class),			//Patchwork only
	/**
	 * Basic drawing color for graphics, not text. For the latter, use the 
	 * 'fontcolor' attribute.
	 */
	color(String.class),
	/**
	 * This attribute specifies a color scheme namespace. If defined, it specifies 
	 * the context for interpreting color names. In particular, if a color value 
	 * has form "xxx" or "//xxx", then the color xxx will be evaluated according 
	 * to the current color scheme. If no color scheme is set, the standard X11 
	 * naming is used. For example, if colorscheme=bugn9, then color=7 is 
	 * interpreted as "/bugn9/7".
	 */
	colorscheme(String.class),
	/**
	 * Comments are inserted into output. Device-dependent.
	 */
	comment(String.class),
	/**
	 * Distortion factor for shape=polygon. Positive values cause top part to 
	 * be larger than bottom; negative values do the opposite.
	 */
	distortion(Double.class),	//[0.0, -100]
	/**
	 * Color used to fill the background of a node or cluster assuming 
	 * style=filled, or a filled arrowhead. If fillcolor is not defined, 
	 * color is used. (For clusters, if color is not defined, bgcolor is 
	 * used.) If this is not defined, the default is used, except for 
	 * shape=point or when the output format is MIF, which use black by 
	 * default.
	 * 
	 * If the value is a colorList, a gradient fill is used. By default, 
	 * this is a linear fill; setting style=radial will cause a radial 
	 * fill. At present, only two colors are used. If the second color 
	 * (after a colon) is missing, the default color is used for it. 
	 * See also the gradientangle attribute for setting the gradient 
	 * angle.
	 * 
	 * Note that a cluster inherits the root graph's attributes if defined. 
	 * Thus, if the root graph has defined a fillcolor, this will override 
	 * a color or bgcolor attribute set for the cluster.
	 */
	fillcolor(String.class),
	/**
	 * If true, the node size is specified by the values of the width and 
	 * height attributes only and is not expanded to contain the text label.
	 */
	fixedsize(Boolean.class),
	/**
	 * Color used for text.
	 */
	fontcolor(String.class),
	/**
	 * Font used for text. This very much depends on the output format and, 
	 * for non-bitmap output such as PostScript or SVG, the availability of 
	 * the font when the graph is displayed or printed. As such, it is best 
	 * to rely on font faces that are generally available, such as 
	 * Times-Roman, Helvetica or Courier.
	 * 
	 * If Graphviz was built using the fontconfig library, the latter library 
	 * will be used to search for the font. However, if the fontname string 
	 * contains a slash character "/", it is treated as a pathname for the 
	 * font file, though font lookup will append the usual font suffixes.
	 * 
	 * If Graphviz does not use fontconfig, fontname will be considered the 
	 * name of a Type 1 or True Type font file. If you specify fontname=schlbk, 
	 * the tool will look for a file named schlbk.ttf or schlbk.pfa or 
	 * schlbk.pfb in one of the directories specified by the fontpath attribute. 
	 * The lookup does support various aliases for the common fonts.
	 */
	fontname(String.class),
	/**
	 * Font size, in points, used for text.
	 */
	fontsize(Double.class),
	/**
	 * If a gradient fill is being used, this determines the angle of the fill. 
	 * For linear fills, the colors transform along a line specified by the 
	 * angle and the center of the object. For radial fills, a value of zero 
	 * causes the colors to transform radially from the center; for non-zero 
	 * values, the colors transform from a point near the object's periphery 
	 * as specified by the value. 
	 * 
	 * If unset, the default angle is 0.
	 */
	gradientangle(Integer.class),
	/**
	 * If the end points of an edge belong to the same group, i.e., have the 
	 * same group attribute, parameters are set to avoid crossings and keep 
	 * the edges straight.
	 */
	group(String.class),			//Dot Only
	/**
	 * Height of node, in inches. This is taken as the initial, minimum height 
	 * of the node. If fixedsize is true, this will be the final height of the 
	 * node. Otherwise, if the node label requires more height to fit, the 
	 * node's height will be increased to contain the label. Note also that, if 
	 * the output format is dot, the value given to height will be the final 
	 * value.
	 * 
	 * If the node shape is regular, the width and height are made identical. In 
	 * this case, if either the width or the height is set explicitly, that value 
	 * is used. In this case, if both the width or the height are set explicitly, 
	 * the maximum of the two values is used. If neither is set explicitly, the 
	 * minimum of the two default values is used. 
	 */
	height(Double.class),
	/**
	 * Synonym for URL.
	 */
	href(String.class),				//Postscript, map only
	/**
	 * Allows the graph author to provide an id for graph objects which is to be 
	 * included in the output. Normal "N", "E", "G" substitutions are applied. 
	 * If provided, it is the reponsiblity of the provider to keep its values 
	 * sufficiently unique for its intended downstream use. Note, in particular, 
	 * that "E" does not provide a unique id for multi-edges. If no id attribute 
	 * is provided, then a unique internal id is used. However, this value is 
	 * unpredictable by the graph writer. An externally provided id is not used 
	 * internally.
	 * 
	 * If the graph provides an id attribute, this will be used as a prefix for 
	 * internally generated attributes. By making these distinct, the user can 
	 * include multiple image maps in the same document.
	 */
	id(String.class),				//Postscript, map only
	/**
	 * Gives the name of a file containing an image to be displayed inside a node. 
	 * The image file must be in one of the recognized formats, typically JPEG, 
	 * PNG, GIF, BMP, SVG or Postscript, and be able to be converted into the 
	 * desired output format.
	 * 
	 * The file must contain the image size information. This is usually trivially 
	 * true for the bitmap formats. For PostScript, the file must contain a line 
	 * starting with %%BoundingBox: followed by four integers specifying the lower 
	 * left x and y coordinates and the upper right x and y coordinates of the 
	 * bounding box for the image, the coordinates being in points. An SVG image 
	 * file must contain width and height attributes, typically as part of the svg 
	 * element. The values for these should have the form of a floating point number, 
	 * followed by optional units, e.g., width="76pt". Recognized units are in, px, 
	 * pc, pt, cm and mm for inches, pixels, picas, points, centimeters and 
	 * millimeters, respectively. The default unit is points.
	 * 
	 * Unlike with the shapefile attribute, the image is treated as node content 
	 * rather than the entire node. In particular, an image can be contained in 
	 * a node of any shape, not just a rectangle.
	 */
	image(String.class),
	/**
	 * Attribute controlling how an image fills its containing node. In general, 
	 * the image is given its natural size, (cf. dpi), and the node size is 
	 * made large enough to contain its image, its label, its margin, and its 
	 * peripheries. Its width and height will also be at least as large as its 
	 * minimum width and height. If, however, fixedsize=true, the width and 
	 * height attributes specify the exact size of the node.
	 * 
	 * During rendering, in the default case (imagescale=false), the image 
	 * retains its natural size. If imagescale=true, the image is uniformly 
	 * scaled (i.e., its aspect ratio is preserved) to fit inside the node. At 
	 * least one dimension of the image will be as large as possible given the 
	 * size of the node. When imagescale=width, the width of the image is scaled 
	 * to fill the node width. The corresponding property holds when 
	 * imagescale=height. When imagescale=both, both the height and the width 
	 * are scaled separately to fill the node.
	 * 
	 * In all cases, if a dimension of the image is larger than the corresponding 
	 * dimension of the node, that dimension of the image is scaled down to fit 
	 * the node. As with the case of expansion, if imagescale=true, width and 
	 * height are scaled uniformly.
	 */
	imagescale(Boolean.class),
	/**
	 * Text label attached to objects. If a node's shape is record, then the 
	 * label can have a special format which describes the record layout.
	 */
	label(DotEscapedString.class),
	/**
	 * Vertical placement of labels for nodes, root graphs and clusters.
	 * 
	 * For graphs and clusters, only "t" and "b" are allowed, corresponding to 
	 * placement at the top and bottom, respectively. By default, root graph 
	 * labels go on the bottom and cluster labels go on the top. Note that a 
	 * subgraph inherits attributes from its parent. Thus, if the root graph sets 
	 * labelloc to "b", the subgraph inherits this value.
	 * 
	 * For nodes, this attribute is used only when the height of the node is 
	 * larger than the height of its label. If labelloc is set to "t", "c", or 
	 * "b", the label is aligned with the top, centered, or aligned with the 
	 * bottom of the node, respectively. In the default case, the label is 
	 * vertically centered.
	 */
	labelloc(String.class),
	/**
	 * Specifies layers in which the node, edge or cluster is present.
	 */
	layer(String.class),
	/**
	 * For graphs, this sets x and y margins of canvas, in inches. If the margin 
	 * is a single double, both margins are set equal to the given value.
	 * 
	 * Note that the margin is not part of the drawing but just empty space left 
	 * around the drawing. It basically corresponds to a translation of drawing, 
	 * as would be necessary to center a drawing on a page. Nothing is actually 
	 * drawn in the margin. To actually extend the background of a drawing, see 
	 * the pad attribute.
	 * 
	 * For clusters, this specifies the space between the nodes in the cluster 
	 * and the cluster bounding box. By default, this is 8 points.
	 * 
	 * For nodes, this attribute specifies space left around the node's label. 
	 * By default, the value is 0.11,0.055.
	 */
	margin(Double.class),
	/**
	 * By default, the justification of multi-line labels is done within the 
	 * largest context that makes sense. Thus, in the label of a polygonal node,
	 *  a left-justified line will align with the left side of the node (shifted 
	 *  by the prescribed margin). In record nodes, left-justified line will 
	 *  line up with the left side of the enclosing column of fields. If 
	 *  nojustify is "true", multi-line labels will be justified in the context 
	 *  of itself. For example, if the attribute is set, the first label line is 
	 *  long, and the second is shorter and left-justified, the second will align 
	 *  with the left-most character in the first line, regardless of how large 
	 *  the node might be.
	 */
	nojustify(Boolean.class),
	/**
	 * If the value of the attribute is "out", then the outedges of a node, that 
	 * is, edges with the node as its tail node, must appear left-to-right in the 
	 * same order in which they are defined in the input. If the value of the 
	 * attribute is "in", then the inedges of a node must appear left-to-right in 
	 * the same order in which they are defined in the input. If defined as a graph 
	 * or subgraph attribute, the value is applied to all nodes in the graph or 
	 * subgraph. Note that the graph attribute takes precedence over the node 
	 * attribute.
	 */
	ordering(String.class),				//Dot only
	/**
	 * Angle, in degrees, used to rotate polygon node shapes. For any number of 
	 * polygon sides, 0 degrees rotation results in a flat base.
	 */
	orientation(Double.class),
	/**
	 * Specifies the width of the pen, in points, used to draw lines and curves, 
	 * including the boundaries of edges and clusters. The value is inherited by 
	 * subclusters. It has no effect on text.
	 * 
	 * Previous to 31 January 2008, the effect of penwidth=W was achieved by 
	 * including setlinewidth(W) as part of a style specification. If both are 
	 * used, penwidth will be used.
	 */
	penwidth(Double.class),
	/**
	 * Set number of peripheries used in polygonal shapes and cluster boundaries. 
	 * Note that user-defined shapes are treated as a form of box shape, so the 
	 * default peripheries value is 1 and the user-defined shape will be drawn 
	 * in a bounding rectangle. Setting peripheries=0 will turn this off. Also, 
	 * 1 is the maximum peripheries value for clusters.
	 */
	peripheries(Integer.class),
	/**
	 * If true and the node has a pos attribute on input, neato or fdp prevents 
	 * the node from moving from the input position. This property can also be 
	 * specified in the pos attribute itself (cf. the point type).
	 * 
	 * Note: Due to an artifact of the implementation, final coordinates are 
	 * translated to the origin. Thus, if you look at the output coordinates 
	 * given in the (x)dot or plain format, pinned nodes will not have the same 
	 * output coordinates as were given on input. If this is important, a simple 
	 * workaround is to maintain the coordinates of a pinned node. The vector 
	 * difference between the old and new coordinates will give the translation, 
	 * which can then be subtracted from all of the appropriate coordinates.
	 */
	pin(Boolean.class),					//fdp, neato only
	/**
	 * Position of node, or spline control points. For nodes, the position 
	 * indicates the center of the node. On output, the coordinates are in 
	 * points.
	 * 
	 * In neato and fdp, pos can be used to set the initial position of a 
	 * node. By default, the coordinates are assumed to be in inches. 
	 * However, the -s command line flag can be used to specify different 
	 * units. As the output coordinates are in points, feeding the output of a 
	 * graph laid out by a Graphviz program into neato or fdp will almost 
	 * always require the -s flag.
	 * 
	 * When the -n command line flag is used with neato, it is assumed the 
	 * positions have been set by one of the layout programs, and are therefore 
	 * in points. Thus, neato -n can accept input correctly without requiring 
	 * a -s flag and, in fact, ignores any such flag.
	 */
	pos(String.class),
	/**
	 * Rectangles for fields of records, in points.
	 */
	rects(String.class),				//Write only
	/**
	 * If true, force polygon to be regular, i.e., the vertices of the polygon 
	 * will lie on a circle whose center is the center of the node.
	 */
	regular(Boolean.class),
	/**
	 * This specifies nodes to be used as the center of the layout and the root 
	 * of the generated spanning tree. As a graph attribute, this gives the 
	 * name of the node. As a node attribute (circo only), it specifies that 
	 * the node should be used as a central node. In twopi, this will actually 
	 * be the central node. In circo, the block containing the node will be 
	 * central in the drawing of its connected component. If not defined, twopi 
	 * will pick a most central node, and circo will pick a random node.
	 * 
	 * If the root attribute is defined as the empty string, twopi will reset it
	 *  to name of the node picked as the root node.
	 */
	root(Boolean.class),				//Circo, twopi only
	/**
	 * If the input graph defines the vertices attribute, and output is dot or 
	 * xdot, this gives the number of points used for a node whose shape is a 
	 * circle or ellipse. It plays the same role in neato, when adjusting the 
	 * layout to avoid overlapping nodes, and in image maps.
	 */
	samplepoints(Integer.class),
	/**
	 * Set the shape of a node.
	 */
	shape(String.class),
	/**
	 * (Deprecated) If defined, shapefile specifies a file containing 
	 * user-supplied node content. The shape of the node is set to box. 
	 * The image in the shapefile must be rectangular. The image formats 
	 * supported as well as the precise semantics of how the file is used 
	 * depends on the output format. For further details, see Image Formats 
	 * and External PostScript files.
	 * 
	 * There is one exception to this usage. If shape is set to "epsf", 
	 * shapefile gives a filename containing a definition of the node in 
	 * PostScript. The graphics defined must be contain all of the node 
	 * content, including any desired boundaries. For further details, see 
	 * External PostScript files.
	 */
	@Deprecated
	shapefile(String.class),
	/**
	 * Print guide boxes in PostScript at the beginning of routesplines 
	 * if 1, or at the end if 2. (Debugging)
	 */
	showboxes(Integer.class),			//Dot only
	/**
	 * Number of sides if shape=polygon.
	 */
	sides(Integer.class),
	/**
	 * Skew factor for shape=polygon. Positive values skew top of polygon to 
	 * right; negative to left.
	 */
	skew(Double.class),
	/**
	 * If packmode indicates an array packing, this attribute specifies an 
	 * insertion order among the components, with smaller values inserted 
	 * first.
	 */
	sortv(Integer.class),
	/**
	 * Set style information for components of the graph. For cluster subgraphs,
	 * if "filled", the cluster box's background is filled.
	 */
	style(String.class),
	/**
	 * If the object has a URL, this attribute determines which window of the 
	 * browser is used for the URL. See W3C documentation.
	 */
	target(String.class),				//svg, map only
	/**
	 * Tooltip annotation attached to the node or edge. If unset, Graphviz will 
	 * use the object's label if defined. Note that if the label is a record 
	 * specification or an HTML-like label, the resulting tooltip may be 
	 * unhelpful. In this case, if tooltips will be generated, the user should 
	 * set a tooltip attribute explicitly.
	 */
	tooltip(String.class),				//svg, cmap only
	/**
	 * If the input graph defines this attribute, the node is polygonal, and 
	 * output is dot or xdot, this attribute provides the coordinates of the 
	 * vertices of the node's polygon, in inches. If the node is an ellipse or 
	 * circle, the samplepoints attribute affects the output.
	 */
	vertices(String.class),				//write only
	/**
	 * Width of node, in inches. This is taken as the initial, minimum width of 
	 * the node. If fixedsize is true, this will be the final width of the node.
	 * Otherwise, if the node label requires more width to fit, the node's width 
	 * will be increased to contain the label. Note also that, if the output 
	 * format is dot, the value given to width will be the final value.
	 * 
	 * If the node shape is regular, the width and height are made identical. In 
	 * this case, if either the width or the height is set explicitly, that value 
	 * is used. In this case, if both the width or the height are set explicitly, 
	 * the maximum of the two values is used. If neither is set explicitly, the 
	 * minimum of the two default values is used.
	 */
	width(Double.class),
	/**
	 * External label for a node or edge. For nodes, the label will be placed 
	 * outside of the node but near it. For edges, the label will be placed near 
	 * the center of the edge. This can be useful in dot to avoid the occasional 
	 * problem when the use of edge labels distorts the layout. For other 
	 * layouts, the xlabel attribute can be viewed as a synonym for the label 
	 * attribute.
	 * 
	 * These labels are added after all nodes and edges have been placed. The 
	 * labels will be placed so that they do not overlap any node or label. 
	 * This means it may not be possible to place all of them. To force placing 
	 * all of them, use the forcelabels attribute.
	 */
	xlabel(String.class),
	/**
	 * DeprecatedUse pos attribute, along with dimen and/or dim to 
	 * specify dimensions.
	 * 
	 * Provides z coordinate value for 3D layouts and displays. If the 
	 * graph has dim set to 3 (or more), neato will use a node's z value 
	 * for the z coordinate of its initial position if its pos attribute 
	 * is also defined.
	 * 
	 * Even if no z values are specified in the input, it is necessary 
	 * to declare a z attribute for nodes, e.g, using node[z=""] in order 
	 * to get z values on output. Thus, setting dim=3 but not declaring z 
	 * will cause neato -Tvrml to layout the graph in 3D but project the 
	 * layout onto the xy-plane for the rendering. If the z attribute is 
	 * declared, the final rendering will be in 3D.
	 */
	@Deprecated
	z(Double.class);
	
	private Class<?> type;
	
	NodeOptions(Class<?> aType) {
		type = aType;
	}
	
	public Class<?> getType() {
		return type;
	}
}
