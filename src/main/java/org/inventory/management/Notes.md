Inward register
Outward register
Invoice management
stock return reason and details


Pending items:

Db integration - done
concurrency - done
authorization - done
authentication - done
advanced restocking strategy - done
logger - done


Restocking strategy:
Factors:
demand
lead time(amount of time that the supplier takes to get the product)
storage space(in godowns/stores)
budget(amount of money left)
seasonality(for seasonal products order more in season and less in off season)
marketing campaigns(if running any amrketing campaigns we need more stock)
pricing(if we are increasing price of a product then we might wnat to have low stiock as demand is ecped to be down)
return policy(if we have a generous return policy we might get products returned more frequently)
Some products are more perishable than others, so you may need to use a different method of restocking (Solution: FIFO system)

Steps:
1. define the demand(we can use previous order statistics and the trend to define the demand)
2. check the lead time from the supplier
3. calculate safety stock(the min no that we want to have per product)
4. based on the above two factors decide the reorder point

Here is an example of how to calculate the reorder point and safety stock for a product that has an average daily demand of 10 units and a lead time of 5 days:

Safety stock = 10 units/day * 5 days = 50 units
Reorder point = 50 units + 10 units/day = 60 units

types:
JustInTime (JIT) inventory only when the stock is needed the order (cons; this might lead to more of out-of-stock scenarios)
Continuous Replenishment is restocking on regular basis regardless of demand. (cons; this helps avoiding out-of-stock scenarios but can lead to overstocking if demand is lower)
Periodic review is restocking every week or one month. This is in between JIT and continuous but it will be more time consuming as we are doing after a long time.
Top-off when the product reaches a certain level then do restocking. But this also can lead to overstocking as this doesnt consider demand rate.

