package Bank;
// this is context and visual builder

import java.util.ArrayList;

import banktestJ.BalanceSheet;
import banktestJ.Constants;
import banktestJ.Network;
import testzombie.Zombie;
import repast.simphony.context.Context;
import repast.simphony.context.space.continuous.ContinuousSpaceFactory;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.context.space.grid.GridFactory;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.environment.RunState;
import repast.simphony.parameter.Parameters;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.continuous.RandomCartesianAdder;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.SimpleGridAdder;
import repast.simphony.space.grid.WrapAroundBorders;

public class testzombieBuilder implements ContextBuilder<Object> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * repast.simphony.dataLoader.ContextBuilder#build(repast.simphony.context
	 * .Context)
	 */
	@Override
	public Context build(Context<Object> context) {
		// TODO Auto-generated method stub

		context.setId("testzombie");

		ContinuousSpaceFactory spaceFactory = ContinuousSpaceFactoryFinder
				.createContinuousSpaceFactory(null);
		ContinuousSpace<Object> space = spaceFactory.createContinuousSpace(
				"space", context, new RandomCartesianAdder<Object>(),
				new repast.simphony.space.continuous.WrapAroundBorders(), 50,
				50);

		GridFactory gridFactory = GridFactoryFinder.createGridFactory(null);
		Grid<Object> grid = gridFactory.createGrid("grid", context,
				new GridBuilderParameters<Object>(new WrapAroundBorders(),
						new SimpleGridAdder<Object>(), true, 50, 50));

		Parameters params = RunEnvironment.getInstance().getParameters();
		for (int i = 0; i < Constants.N; i++) {

		}

		int k = 0;
		for (Object obj : context) {
			NdPoint pt = space.getLocation(obj);
			grid.moveTo(obj, (int) pt.getX(), (int) pt.getY());
			k++;
		}

		// --------------------------------------------------------------------

		new Network();
		new BalanceSheet();

		// double[] nuArray = new double[5];

		// nuArray = BalanceSheet.getBalanceSheet(1);

		// -------------------------------------------------------------------
		// creating agent
		for (int i = 0; i < Constants.N; i++) {
			// System.out.println(grid);
			context.add(new Zombie(i, BalanceSheet.getBalanceSheet(i)));

		}

		/*
		 * int countobject = 0;
		 * 
		 * for(Object obj : context){ NdPoint pt = space.getLocation(obj);
		 * grid.moveTo(obj, (int)pt.getX(), (int)pt.getY());
		 * System.out.println(pt); countobject++;
		 * System.out.println(countobject); }
		 */

		return context;
	}

	// public static Object polarcoord (int r, int theta){
	// NdPoint pt = new ;
	// return pt;
	// }

	/*
	 * public ArrayList<Zombie> getZombieList() {
	 * 
	 * @SuppressWarnings("unchecked") final Iterable<Zombie> Zombies =
	 * RunState.getInstance().getMasterContext() .getObjects(Zombie.class);
	 * final ArrayList<Zombie> bugList = new ArrayList<Zombie>();
	 * 
	 * for (final Zombie bug : Zombies) { bugList.add(bug); }
	 * 
	 * return bugList; }
	 */
}
